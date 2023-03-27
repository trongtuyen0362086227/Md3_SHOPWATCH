package ra.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.Producer;
import ra.model.entity.User;
import ra.model.service.UserService;
import ra.model.serviceImp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private static UserService<User, Integer> userService = new UserServiceImp();
    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")) {
            getAllUser(request, response);
//        } else if (action.equals("GetById")) {
//            int producerId = Integer.parseInt(request.getParameter("producerId"));
//            Producer producerUpdate = producerService.findById(producerId);
//            String json = GSON.toJson(producerUpdate);
//            response.setCharacterEncoding("UTF-8");
//            response.setStatus(200);
//            response.setHeader("content-Type", "application/json");
//            Writer out = response.getWriter();
//            out.write(json);
//            out.flush();
//        } else if (action != null && action.equals("Search")) {
//            List<Producer> listSearchProducer = producerService.searchByName(request.getParameter("searchName"));
//            request.setAttribute("listProducer", listSearchProducer);
//            request.getRequestDispatcher("views/producer.jsp").forward(request, response);
        }
    }

    public void getAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<User> listUser = userService.findAll();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("views/useradmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("Register")) {
            User user = new User();
            user.setUserName(request.getParameter("username"));
            user.setPasswords(request.getParameter("password"));
            user.setConfirmPasswords(request.getParameter("confirmPass"));
            user.setFullName(request.getParameter("fullname"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthdate(sdf.parse(request.getParameter("birthdate")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            user.setAddress(request.getParameter("address"));
            user.setEmail(request.getParameter("email"));
            user.setPhone(request.getParameter("phone"));
            user.setImage(null);
            user.setPermission(false);
            user.setUserStatus(true);
            boolean result = userService.save(user);
            if (result) {
                response.sendRedirect("views/index.jsp");
            }
        } else if (action.equals("login")) {
            User user = null;
            String userName = request.getParameter("username");
            String pass = request.getParameter("password");
            user = userService.login(userName, pass);
            if (user!=null){
                if (user.isUserStatus()&&user.isPermission()){
                    response.sendRedirect("views/indexadmin.jsp");
                } else if (user.isUserStatus()&&!user.isPermission()){
                    response.sendRedirect("views/home.jsp");
                } else {
                    response.sendRedirect("views/index.jsp");
                }
            }
        } else if (action.equals("Delete")){
           int userId = Integer.parseInt(request.getParameter("userDeleteId"));
           boolean result = userService.delete(userId);
           if (result){
               getAllUser(request,response);
           }
        } else if (action.equals("Unlock")){
            int userId = Integer.parseInt(request.getParameter("unlockUserId"));
            boolean result = userService.unlock(userId);
            if (result) {
                getAllUser(request,response);
            }
        }
    }
}

