/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MFeedBack {
     public void addFeedback(Date date,String discriptionint,int employeid,String employename){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO Feedback (Date,Description,EmployeeID,EmployeeName) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            
           
            pst.setDate(1, date);
            pst.setString(2, discriptionint);
            pst.setInt(3, employeid);
            pst.setString(4, employename);


            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Feedback Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
   
   public void updateFeedback(int feedbackid,Date date,String discriptionint,int employeid,String employename){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE Feedback SET Date = ?, Description = ?, EmployeeID = ?, EmployeeName = ? WHERE FeedbackID = ?";
            pst = con.prepareStatement(sql);
             pst.setDate(1, date);
            pst.setString(2, discriptionint);
            pst.setInt(3, employeid);
            pst.setString(4, employename);
            pst.setInt(5, feedbackid);
            
            
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Feedback Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                     // JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
        
        public void deleteFeedback(int feedbackid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Feedback WHERE FeedbackID  = '" + feedbackid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "feedback deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No feedback found with ID " + feedbackid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
}
