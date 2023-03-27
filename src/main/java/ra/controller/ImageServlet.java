package ra.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.CatalogCombobox;
import ra.model.entity.CatalogInfo;
import ra.model.entity.Image;
import ra.model.entity.Producer;
import ra.model.service.ImageService;
import ra.model.serviceImp.ImageServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "ImageServlet", value = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    private static ImageService<Image,Integer> imageService = new ImageServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")) {
            getAllImage(request, response);
//        } else if (action.equals("GetById")) {
//            int imageId = Integer.parseInt(request.getParameter("producerId"));
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
    public void getAllImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Image> listImage = imageService.findAll();
        request.setAttribute("listImage", listImage);
        request.getRequestDispatcher("views/imageLink.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
