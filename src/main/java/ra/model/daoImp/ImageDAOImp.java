package ra.model.daoImp;

import ra.model.dao.ImageDAO;
import ra.model.entity.Image;
import ra.model.entity.Producer;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAOImp implements ImageDAO<Image, Integer> {
    @Override
    public List<Image> findAll() {
        List<Image> listImage = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllImage()}");
            ResultSet rs = callSt.executeQuery();
            listImage = new ArrayList<>();
            while (rs.next()) {
                Image image = new Image();
                image.setImageId(rs.getInt("imageid"));
                image.setImageName(rs.getString("imagName"));
                image.setLink(rs.getString("link"));
                image.setProductId(rs.getInt("productid"));
                image.setImageStatus(rs.getBoolean("imagestatus"));
                listImage.add(image);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listImage;
    }

    @Override
    public Image findById(Integer id) {
        Image image = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getImageById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            image = new Image();
            if (rs.next()) {
                image.setImageId(rs.getInt("imageid"));
                image.setImageName(rs.getString("imagName"));
                image.setLink(rs.getString("link"));
                image.setProductId(rs.getInt("productid"));
                image.setImageStatus(rs.getBoolean("imagestatus"));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return image;
    }

    @Override
    public boolean save(Image image) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_inserImage(?,?,?,?)}");
            callSt.setString(1, image.getImageName());
            callSt.setString(2, image.getLink());
            callSt.setInt(3, image.getProductId());
            callSt.setBoolean(4,image.isImageStatus());
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
    public boolean update(Image image) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateImage(?,?,?,?,?)}");
            callSt.setInt(1, image.getImageId());
            callSt.setString(2, image.getImageName());
            callSt.setString(3, image.getLink());
            callSt.setInt(4, image.getProductId());
            callSt.setBoolean(5,image.isImageStatus());
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
            callSt = conn.prepareCall("{call proc_deleteImage(?)}");
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
    public List<Image> searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Image> listImage = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchImageByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            listImage = new ArrayList<>();
            while (rs.next()) {
                Image image = new Image();
                image.setImageId(rs.getInt("imageid"));
                image.setImageName(rs.getString("imagName"));
                image.setLink(rs.getString("link"));
                image.setProductId(rs.getInt("productid"));
                image.setImageStatus(rs.getBoolean("imagestatus"));
                listImage.add(image);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listImage;
    }
}
