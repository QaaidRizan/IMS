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
public class MExpense {
    public void addExpense(Date date,String discription,int amount){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO Expense (Date,Description, Amount) VALUES (?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setDate(1, date);
            pst.setString(2, discription);
            pst.setInt(3, amount);

            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Expense Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
   
   public void updateExpense(int expenseid,Date date,String discription,int amount){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE Expense SET Date = ?, Description = ?, Amount = ? WHERE ExpenseID = ?";
            pst = con.prepareStatement(sql);
             pst.setDate(1, date);
            pst.setString(2, discription);
            pst.setInt(3, amount);
            pst.setInt(4, expenseid);
            
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Expense Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                     // JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
        
        public void deleteExpense(int expenseid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Expense WHERE ExpenseID  = '" + expenseid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Expense deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Expense found with ID " + expenseid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
}
