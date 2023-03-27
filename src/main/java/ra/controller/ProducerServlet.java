package ra.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.Catalog;
import ra.model.entity.CatalogCombobox;
import ra.model.entity.CatalogInfo;
import ra.model.entity.Producer;
import ra.model.service.ProducerService;
import ra.model.serviceImp.ProducerServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "ProducerServlet", value = "/ProducerServlet")
public class ProducerServlet extends HttpServlet {
    private static ProducerService<Producer, Integer> producerService = new ProducerServiceImp();
    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")) {
            getAllProducer(request, response);
        } else if (action.equals("GetById")) {
            int producerId = Integer.parseInt(request.getParameter("producerId"));
            Producer producerUpdate = producerService.findById(producerId);
            String json = GSON.toJson(producerUpdate);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.setHeader("content-Type", "application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        } else if (action != null && action.equals("Search")) {
            List<Producer> listSearchProducer = producerService.searchByName(request.getParameter("searchName"));
            request.setAttribute("listProducer", listSearchProducer);
            request.getRequestDispatcher("views/producer.jsp").forward(request, response);
        }
    }


    public void getAllProducer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Producer> listProducer = producerService.findAll();
        request.setAttribute("listProducer", listProducer);
        request.getRequestDispatcher("views/producer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Producer producer = new Producer();
            producer.setProducerName(request.getParameter("producerName"));
            producer.setImage(request.getParameter("image"));
            producer.setProducerStatus(Boolean.parseBoolean(request.getParameter("producerStatus")));
            System.out.println(request.getParameter("producerStatus"));
            boolean result = producerService.save(producer);
            if (result) {
                getAllProducer(request, response);
            }
        } else if (action != null && action.equals("Delete")) {
            int producerId = Integer.parseInt(request.getParameter("proDeleteId"));
            boolean result = producerService.delete(producerId);
            if (result) {
                getAllProducer(request, response);
            }
        } else if (action.equals("Update")) {
            Producer producer = new Producer();
            producer.setProducerId(Integer.parseInt(request.getParameter("producerId")));
            producer.setProducerName(request.getParameter("producerName"));
            if (request.getParameter("imageUpdate") == null || request.getParameter("imageUpdate") == "") {
                producer.setImage(request.getParameter("oldImage"));
            } else {
                producer.setImage(request.getParameter("imageUpdate"));
            }
            producer.setProducerStatus(Boolean.parseBoolean(request.getParameter("producerStatus")));
            boolean result = producerService.update(producer);
            if (result) {
                getAllProducer(request, response);
            }
        }
    }
}



