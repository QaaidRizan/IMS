/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MUserAccount {
   public void registerUser(int userid,String username,String password1,String fullname,String fname,String lname,String loaction,String mail,Date sqlCreateDate,int phoneNumber,Date dateofbirth,String role) {
    try{
        
         String sql = "INSERT INTO UserAccount(User_ID,User_Name, Password,Name_With_Initials,First_Name,Last_Name,Address,Email,Created_At,Phone,DOB,Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       PreparedStatement pst = MDBConnection.createConnection().prepareStatement(sql);
        pst.setInt(1, userid);
        pst.setString(2, username);
        pst.setString(3, password1);
        pst.setString(4, fullname);
        pst.setString(5, fname);
        pst.setString(6, lname);
        pst.setString(7, loaction);
        pst.setString(8, mail);
        pst.setDate(9,sqlCreateDate);
        pst.setInt(10, phoneNumber);
        pst.setDate(11,dateofbirth);
        pst.setString(12, role);

        int count = pst.executeUpdate();

        if (count > 0) {
            JOptionPane.showMessageDialog(null, "User Registered!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
}
   public void deleteUser(int user_Id)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM UserAccount WHERE User_ID  = '" + user_Id + "'");
            if (count > 0) {
                
            } else {
                
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
   public void updateMember(int userid,String username,String password1,String fullname,String fname,String lname,String loaction,String mail,Date sqlCreateDate,int phoneNumber,Date dateofbirth,String role) {
        try {
            Connection conn = MDBConnection.createConnection();
            String sql = "UPDATE UserAccount SET User_Name = ?, Password = ?, Name_With_Initials = ?, First_Name = ?, Last_Name = ? ,Address = ?,Email = ?,Created_At = ?,Phone = ?,DOB = ?,Role = ? WHERE User_ID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, username);
            pst.setString(2, password1);
            pst.setString(3, fullname);
            pst.setString(4, fname);
            pst.setString(5, lname);
            pst.setString(6, loaction);
            pst.setString(7, mail);
            pst.setDate(8, sqlCreateDate);
            pst.setInt(9, phoneNumber);
            pst.setDate(10, dateofbirth);
            pst.setString(11, role);
            pst.setInt(12, userid);
            
            int count = pst.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "User Account Updated !!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "User Account ID not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error updating User Account: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }
}
