/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MRequestLeave {
    
      public void addLeave(int employeid,Date startdate,Date enddate,String reson){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO ELeave (EmployeeID, StartingDate, EndingDate, Reason) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, employeid);;
            pst.setDate(2, startdate);
            pst.setDate(3, enddate);
            pst.setString(4, reson);

            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Leave Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
   
   public void updateLeave(int leaveid,int employeid,Date startdate,Date enddate,String reson){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE ELeave SET EmployeeID = ?, StartingDate = ?, EndingDate = ?, Reason = ? WHERE LeaveID = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, employeid);
            pst.setDate(2, startdate);
            pst.setDate(3, enddate);
            pst.setString(4, reson);
            pst.setInt(5, leaveid);
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Product Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                      JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
        
        public void deleteLeave(int leaveid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM ELeave WHERE LeaveID  = '" + leaveid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Leave deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No LeaveID found with ID " + leaveid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }

    
}
