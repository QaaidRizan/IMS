/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MLogin;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class CLogin {
        public ResultSet login(String username, String password) {
        MLogin ml = new MLogin();
        ResultSet rst2 = null;
        try {
            rst2 = ml.login(username, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rst2;
    }
  public ResultSet Userlogin(String role,String username, String password){
  
       
        MLogin ml = new MLogin();
        ResultSet rst = null;
        try {
            rst = ml.Userlogin(role, username, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
            return rst;
    
 }
}
