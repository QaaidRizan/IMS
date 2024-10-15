/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author USER
 */
public class MLogin {
     public ResultSet login(String username, String password) throws SQLException {
        ResultSet rst = null;
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = MDBConnection.createConnection();
            String sql = "SELECT AdminUserName, password FROM admin WHERE AdminUserName = ? AND password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rst = pst.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e; // Re-throw the exception to handle it in the calling method
        } finally {
            // We will close the ResultSet, PreparedStatement, and Connection in the calling method
        }
        return rst;
    }
     public ResultSet Userlogin(String role,String username, String password) throws SQLException {
        ResultSet rst = null;
        ResultSet rst2 = null;
        Connection conn = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;

        try {
            conn = MDBConnection.createConnection();
            String sql = "SELECT Role,User_Name,Password FROM UserAccount WHERE Role= ? AND User_Name = ? AND Password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, role);
            pst.setString(2, username);
            pst.setString(3, password);
            rst = pst.executeQuery();
            String sql2 = "SELECT AdminUserName, Password FROM admin WHERE AdminUserName = ? AND password = ?";
            pst2 = conn.prepareStatement(sql2);
            pst2.setString(1, username);
            pst2.setString(2, password);
            rst2 = pst2.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e; // Re-throw the exception to handle it in the calling method
        } finally {
            // We will close the ResultSet, PreparedStatement, and Connection in the calling method
        }
        return rst;
    }
    
}
