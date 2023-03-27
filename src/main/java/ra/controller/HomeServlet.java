package ra.controller;

import ra.model.entity.*;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static ProductService<Product,Integer> productService = new ProductServiceImp();
    private static CatalogService<CatalogInfo,Integer> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Product> listProduct = productService.findAll();
        List<CatalogInfo> listCat = catalogService.findAll();
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listCat", listCat);
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
