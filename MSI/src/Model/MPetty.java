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
public class MPetty {
       public void addPettyCash(Date date,String discription,int amount){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO PettyCash (Date,Description, Amount) VALUES (?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setDate(1, date);
            pst.setString(2, discription);
            pst.setInt(3, amount);

            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "PettyCash Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
   
   public void updatePettyCash(int pettycashid,Date date,String discription,int amount){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE PettyCash SET Date = ?, Description = ?, Amount = ? WHERE PettyID = ?";
            pst = con.prepareStatement(sql);
             pst.setDate(1, date);
            pst.setString(2, discription);
            pst.setInt(3, amount);
            pst.setInt(4, pettycashid);
            
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "PettyCash Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                     // JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
        
        public void deletePettyCash(int pettycashid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Expense WHERE ExpenseID  = '" + pettycashid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "pettycash deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No pettycash found with ID " + pettycashid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
}
