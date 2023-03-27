package ra.controller;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.CatalogInfo;
import ra.model.entity.Producer;
import ra.model.entity.Product;
import ra.model.service.CatalogService;
import ra.model.service.ProducerService;
import ra.model.service.ProductService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProducerServiceImp;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static ProductService<Product,Integer> productService = new ProductServiceImp();
    private static CatalogService<CatalogInfo, Integer> catalogService = new CatalogServiceImp();
    private static ProducerService<Producer, Integer> producerService = new ProducerServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")){
            getAllProduct(request,response);
        }else if (action.equals("getById")) {
            int proId = Integer.parseInt(request.getParameter("productId"));
            Product proUpdate = productService.findById(proId);
            String json = GSON.toJson(proUpdate);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.setHeader("content-Type", "application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }else if (action != null && action.equals("Search")) {
            List<Product> listSearchProduct = productService.searchByName(request.getParameter("searchName"));
            request.setAttribute("listProduct", listSearchProduct);
            request.getRequestDispatcher("views/productadmin.jsp").forward(request, response);
        }
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Product> listProduct = productService.findAll();
        List<CatalogInfo> listCat = catalogService.findAll();
        List<Producer> listProducer = producerService.findAll();
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listCat", listCat);
        request.setAttribute("listProducer", listProducer);
        request.getRequestDispatcher("views/productadmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Product pro = new Product();
            pro.setProductName(request.getParameter("productName"));
            pro.setPrice(Float.parseFloat(request.getParameter("price")));
            pro.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            pro.setTitle(request.getParameter("title"));
            pro.setDepcriptions(request.getParameter("depscriptions"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                pro.setCreated(sdf.parse(request.getParameter("created")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            pro.setImage(request.getParameter("image"));
            pro.setProductstatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            pro.setCatalogId(Integer.parseInt(request.getParameter("catalog")));
            pro.setProducerid(Integer.parseInt(request.getParameter("producer")));
            boolean result = productService.save(pro);
            if (result) {
                getAllProduct(request, response);
            }
        } else if (action != null && action.equals("Delete")) {
            int proid = Integer.parseInt(request.getParameter("productDeleteId"));
            boolean result = productService.delete(proid);
            if (result) {
                getAllProduct(request, response);
            }
        }else if (action.equals("Update")) {
            Product pro = new Product();
            pro.setProductId(Integer.parseInt(request.getParameter("productIdUpdate")));
            pro.setProductName(request.getParameter("productNameUpdate"));
            pro.setPrice(Float.parseFloat(request.getParameter("priceUpdate")));
            pro.setQuantity(Integer.parseInt(request.getParameter("quantityUpdate")));
            pro.setTitle(request.getParameter("titleUpdate"));
            pro.setDepcriptions(request.getParameter("depscriptionsUpdate"));
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                pro.setCreated(sdf.parse(request.getParameter("createdUpdate")));
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
            if (request.getParameter("imageUpdate")==""||request.getParameter("imageUpdate")==null){
                pro.setImage(request.getParameter("oldImage"));
            } else {
                pro.setImage(request.getParameter("imageUpdate"));
            }
            pro.setProductstatus(Boolean.parseBoolean(request.getParameter("productStatusUpdate")));
            pro.setCatalogId(Integer.parseInt(request.getParameter("catalogUpdate")));
            pro.setProducerid(Integer.parseInt(request.getParameter("producerUpdate")));
            boolean result = productService.update(pro);
            if (result) {
                getAllProduct(request, response);
            }
        }
    }
}
