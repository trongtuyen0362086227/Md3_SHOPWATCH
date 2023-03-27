package ra.model.daoImp;

import ra.model.dao.ProductDAO;
import ra.model.entity.Producer;
import ra.model.entity.Product;
import ra.model.entity.User;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO<Product,Integer> {
    @Override
    public List<Product> findAll() {
        List<Product> listProduct = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductId(rs.getInt("productid"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setTitle(rs.getString("title"));
                pro.setDepcriptions(rs.getString("depcriptions"));
                pro.setCreated(rs.getDate("created"));
                pro.setCatalogId(rs.getInt("catalogid"));
                pro.setProducerid(rs.getInt("catalogid"));
                pro.setImage(rs.getString("image"));
                pro.setProductstatus(rs.getBoolean("productstatus"));
                listProduct.add(pro);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;

    }

    @Override
    public Product findById(Integer id) {
        Product pro = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getProductById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            pro = new Product();
            if (rs.next()) {
                pro.setProductId(rs.getInt("productid"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setTitle(rs.getString("title"));
                pro.setDepcriptions(rs.getString("depcriptions"));
                pro.setCreated(rs.getDate("created"));
                pro.setCatalogId(rs.getInt("catalogid"));
                pro.setProducerid(rs.getInt("producerid"));
                pro.setImage(rs.getString("image"));
                pro.setProductstatus(rs.getBoolean("productstatus"));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return pro;
    }

    @Override
    public boolean save(Product product) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_inserProduct(?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, product.getProductName());
            callSt.setFloat(2,product.getPrice());
            callSt.setInt(3, product.getQuantity());
            callSt.setInt(4,product.getCatalogId());
            callSt.setString(5,product.getTitle());
            callSt.setDate(6,new Date(product.getCreated().getTime()));
            callSt.setString(7,product.getImage());
            callSt.setString(8,product.getDepcriptions());
            callSt.setBoolean(9,product.isProductstatus());
            callSt.setInt(10,product.getProducerid());

            callSt.executeUpdate();
        } catch (SQLException ex1) {
            result = false;
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateProduct(?,?,?,?,?,?,?,?,?,?)}");
            callSt.setInt(1,product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3,product.getPrice());
            callSt.setInt(4, product.getQuantity());
            callSt.setString(5,product.getDepcriptions());
            callSt.setString(6,product.getTitle());
//            callSt.setDate(7,new Date(product.getCreated().getTime()));
            callSt.setString(7,product.getImage());
            callSt.setInt(8,product.getCatalogId());
            callSt.setInt(9,product.getProducerid());
            callSt.setBoolean(10,product.isProductstatus());
            callSt.executeUpdate();
        } catch (SQLException ex1) {
            result = false;
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_deleteProduct(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException ex1) {
            result = false;
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public List<Product> searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchProductByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductId(rs.getInt("productid"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setTitle(rs.getString("title"));
                pro.setDepcriptions(rs.getString("depcriptions"));
                pro.setCreated(rs.getDate("created"));
                pro.setCatalogId(rs.getInt("catalogid"));
                pro.setProducerid(rs.getInt("producerid"));
                pro.setImage(rs.getString("image"));
                pro.setProductstatus(rs.getBoolean("productstatus"));
                listProduct.add(pro);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }
}
