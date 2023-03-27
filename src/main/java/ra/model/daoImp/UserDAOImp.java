package ra.model.daoImp;

import ra.model.dao.UserDAO;
import ra.model.entity.User;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO<User,Integer> {
    @Override
    public List<User> findAll() {
        List<User> listUser = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllUser()}");
            ResultSet rs = callSt.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("username"));
                user.setPasswords(rs.getString("passwords"));
                user.setConfirmPasswords(rs.getString("confirmpass"));
                user.setFullName(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPermission(rs.getBoolean("permission"));
                user.setUserStatus(rs.getBoolean("userstatus"));
                user.setImage(rs.getString("image"));
                user.setBirthdate(rs.getDate("birthdate"));
                listUser.add(user);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listUser;
    }

    @Override
    public User findById(Integer id) {
        User user = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getUserById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("username"));
                user.setPasswords(rs.getString("passwords"));
                user.setConfirmPasswords(rs.getString("confirmpass"));
                user.setFullName(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPermission(rs.getBoolean("permission"));
                user.setUserStatus(rs.getBoolean("userstatus"));
                user.setImage(rs.getString("image"));
                user.setBirthdate(rs.getDate("birthdate"));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertUser(?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getPasswords());
            callSt.setString(3, user.getConfirmPasswords());
            callSt.setString(4, user.getFullName());
            callSt.setDate(5,new Date( user.getBirthdate().getTime()));
            callSt.setString(6,user.getAddress());
            callSt.setString(7,user.getEmail());
            callSt.setString(8,user.getPhone());
            callSt.setString(9,user.getImage());
            callSt.setBoolean(10,user.isPermission());
            callSt.setBoolean(11,user.isUserStatus());
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
    public boolean update(User user) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateUser(?,?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setInt(1,user.getUserId());
            callSt.setString(2, user.getUserName());
            callSt.setString(3, user.getPasswords());
            callSt.setString(4, user.getConfirmPasswords());
            callSt.setString(5, user.getFullName());
            callSt.setDate(6,new Date( user.getBirthdate().getTime()));
            callSt.setString(7,user.getAddress());
            callSt.setString(8,user.getEmail());
            callSt.setString(9,user.getPhone());
            callSt.setString(10,user.getImage());
            callSt.setBoolean(11,user.isPermission());
            callSt.setBoolean(12,user.isUserStatus());
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
            callSt = conn.prepareCall("{call proc_deleteUser(?)}");
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
    public List<User> searchByName(String name) {
        List<User> listUser = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getComboboxCatalog()}");
            ResultSet rs = callSt.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                callSt = conn.prepareCall("{call proc_updateUser(?,?,?,?,?,?,?,?,?,?,?,?)}");
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("username"));
                user.setPasswords(rs.getString("passwords"));
                user.setConfirmPasswords(rs.getString("confirmpass"));
                user.setFullName(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPermission(rs.getBoolean("permission"));
                user.setUserStatus(rs.getBoolean("userstatus"));
                user.setImage(rs.getString("image"));
                user.setBirthdate(rs.getDate("birthdate"));
                listUser.add(user);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listUser;
    }

    @Override
    public User login(String userName, String password) {
        User user = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_login(?,?)}");
            callSt.setString(1, userName);
            callSt.setString(2, password);
            ResultSet rs = callSt.executeQuery();
            user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("username"));
                user.setPasswords(rs.getString("passwords"));
                user.setConfirmPasswords(rs.getString("confirmpass"));
                user.setFullName(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPermission(rs.getBoolean("permission"));
                user.setUserStatus(rs.getBoolean("userstatus"));
                user.setImage(rs.getString("image"));
                user.setBirthdate(rs.getDate("birthdate"));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }
    public boolean unlock(Integer id){
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_unlockUser(?)}");
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
}
