/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author USER
 */
public class MStock {
    
      public void addStock(int qty, int productid, int supplierid, Date sqlStockDate, int price) {
    Connection con;
    PreparedStatement pst = null;
    PreparedStatement pstUpdate = null;
    
    try {        
        con = MDBConnection.createConnection();
        // Insert into Stock table
        String sql = "INSERT INTO Stock (Qty, ProductID, SupplierID, StockDate, Price) VALUES (?, ?, ?, ?, ?)";
        pst = con.prepareStatement(sql);
        
        pst.setInt(1, qty);
        pst.setInt(2, productid);
        pst.setInt(3, supplierid);
        pst.setDate(4, sqlStockDate);
        pst.setInt(5, price);
        
        int count = pst.executeUpdate(); // Only execute once
        
        // Update the product quantity in the Product table
        String updateProductSql = "UPDATE product SET Qty = Qty + ? WHERE ProductID = ?";
        pstUpdate = con.prepareStatement(updateProductSql);
        
        pstUpdate.setInt(1, qty);
        pstUpdate.setInt(2, productid);
        
        int count1 = pstUpdate.executeUpdate(); // Only execute once

        if (count > 0 && count1 > 0) {
            JOptionPane.showMessageDialog(null, "Stock Details Added!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close PreparedStatements and Connection to avoid memory leaks
        try {
            if (pst != null) pst.close();
            if (pstUpdate != null) pstUpdate.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

          
        
        
    
      
      
     
     public void updateStock (int stockid, int qty,int productid,int supplierid,Date sqlStockDate){
            Connection con;
         PreparedStatement pst = null;
        try{ 
            con = MDBConnection.createConnection();
            String sql = "UPDATE Stock SET Qty = ?, ProductID = ?, SupplierID = ?,StockDate = ? WHERE StockID = ?";
            pst = con.prepareStatement(sql);
      
            
          
            pst.setInt(1, qty);
            pst.setInt(2, productid);
            pst.setInt(3, supplierid);            
            pst.setDate(4, sqlStockDate);
            pst.setInt(5, stockid);
            int count = pst.executeUpdate();
            
            
            if(count>0){
                JOptionPane.showMessageDialog(null, "Stock Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                      JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);            
        }
   }
     
     
     
     public void deleteSupplier(int stockid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Stock WHERE StockID  = '" + stockid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "stock deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No stockid found with ID " + stockid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
}
