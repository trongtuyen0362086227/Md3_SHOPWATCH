package ra.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.Catalog;
import ra.model.entity.CatalogCombobox;
import ra.model.entity.CatalogInfo;
import ra.model.service.CatalogService;
import ra.model.serviceImp.CatalogServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private static CatalogService<CatalogInfo, Integer> catalogService = new CatalogServiceImp();
    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")) {
            getAllCatalog(request, response);
        } else if (action.equals("getById")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            Catalog catUpdate = catalogService.findById(catalogId);
            String json = GSON.toJson(catUpdate);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.setHeader("content-Type", "application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }else if (action != null && action.equals("Search")) {
            List<CatalogInfo> listSearchCatalog = catalogService.searchByName(request.getParameter("searchName"));
            request.setAttribute("listCat",listSearchCatalog);
            request.getRequestDispatcher("views/categoryadmin.jsp").forward(request,response);
        }
    }

    public void getAllCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<CatalogInfo> listCat = catalogService.findAll();
        List<CatalogCombobox> ListCatCombo = catalogService.findCatalogCombobox();
        request.setAttribute("listCat", listCat);
        request.setAttribute("ListCatCombo", ListCatCombo);
        request.getRequestDispatcher("views/categoryadmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            CatalogInfo catalog = new CatalogInfo();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setDepcriptions(request.getParameter("depcriptions"));
            catalog.setParentId(Integer.parseInt(request.getParameter("parentId")));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.save(catalog);
            if (result) {
                getAllCatalog(request, response);
            }
        } else if (action != null && action.equals("Delete")) {
            int catid = Integer.parseInt(request.getParameter("catalogDeleteId"));
            boolean result = catalogService.delete(catid);
            if (result) {
                getAllCatalog(request, response);
            }
        } else if (action.equals("Update")) {
            CatalogInfo catInfo = new CatalogInfo();
            catInfo.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            catInfo.setCatalogName(request.getParameter("catNameUpdate"));
            catInfo.setDepcriptions(request.getParameter("depcriptionsUpdate"));
            catInfo.setParentId(Integer.parseInt(request.getParameter("parentId")));
            catInfo.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.update(catInfo);
            if (result) {
                getAllCatalog(request, response);
            }
        }
    }
}
