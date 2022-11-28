package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVE = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/watch_CSDL";
    private static final String USERNAME = "root";
    private static final String PASS = "tuyenlinh10";
    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVE);
            conn = DriverManager.getConnection(URL,USERNAME,PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement callSt){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt!=null){
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
