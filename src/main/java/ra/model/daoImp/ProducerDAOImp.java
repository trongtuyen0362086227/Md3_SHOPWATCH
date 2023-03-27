package ra.model.daoImp;

import ra.model.dao.ProdcerDAO;
import ra.model.entity.Producer;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerDAOImp implements ProdcerDAO<Producer,Integer> {
    @Override
    public List<Producer> findAll() {
        List<Producer> listProducer = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllProducer()}");
            ResultSet rs = callSt.executeQuery();
            listProducer = new ArrayList<>();
            while (rs.next()) {
                Producer producer = new Producer();
                producer.setProducerId(rs.getInt("producerId"));
                producer.setProducerName(rs.getString("producerName"));
                producer.setImage(rs.getString("image"));
                producer.setProducerStatus(rs.getBoolean("producerStatus"));
                listProducer.add(producer);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProducer;
    }

    @Override
    public Producer findById(Integer id) {
        Producer producer = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getProducerById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            producer = new Producer();
            if (rs.next()) {
                producer.setProducerId(rs.getInt("producerId"));
                producer.setProducerName(rs.getString("producerName"));
                producer.setImage(rs.getString("image"));
                producer.setProducerStatus(rs.getBoolean("producerStatus"));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return producer;
    }

    @Override
    public boolean save(Producer producer) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_inserProducer(?,?,?)}");
            callSt.setString(1, producer.getProducerName());
            callSt.setString(2, producer.getImage());
            callSt.setBoolean(3, producer.isProducerStatus());
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
    public boolean update(Producer producer) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateProducer(?,?,?,?)}");
            callSt.setInt(1, producer.getProducerId());
            callSt.setString(2, producer.getProducerName());
            callSt.setString(3, producer.getImage());
            callSt.setBoolean(4, producer.isProducerStatus());
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
            callSt = conn.prepareCall("{call proc_deleteProducer(?)}");
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
    public List<Producer> searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Producer> listProducer = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchProducerByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            listProducer = new ArrayList<>();
            while (rs.next()) {
                Producer producer = new Producer();
                producer.setProducerId(rs.getInt("producerid"));
                producer.setProducerName(rs.getString("producername"));
                producer.setImage(rs.getString("image"));
                producer.setProducerStatus(rs.getBoolean("producerStatus"));
                listProducer.add(producer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProducer;
    }
}
