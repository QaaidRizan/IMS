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
public class MSalary {
    
    public void addSalary(Date sdate,int bsalary,int allowance,int employid){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO Salary (SalaryDate,BasicSalary,Allowance,EmployeeID) VALUES (?, ?, ?,?)";
            pst = con.prepareStatement(sql);
            
            pst.setDate(1, sdate);
            pst.setInt(2, bsalary);
            pst.setInt(3, allowance);
            pst.setInt(4, employid);

            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Salary Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
   
   public void updateSalary(int salaryid,Date sdate,int bsalary,int allowance,int employid){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE Salary SET SalaryDate = ?, BasicSalary = ?, Allowance = ? ,EmployeeID=? WHERE SalaryID = ?";
            pst = con.prepareStatement(sql);
             pst.setDate(1, sdate);
            pst.setInt(2, bsalary);
            pst.setInt(3, allowance);
            pst.setInt(4, employid);
            pst.setInt(5, salaryid);
            
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Salary Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                     // JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
        
        public void deleteSalary(int salaryid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Salary WHERE SalaryID  = '" + salaryid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "salary deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No salary found with ID " + salaryid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
}
