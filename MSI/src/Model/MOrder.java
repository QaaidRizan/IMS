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
public class MOrder {
     public void addOrder(int orderid, Date sqlcreatedate, int productid, int qty, int total) {
    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pstUpdate = null;

    try {
        con = MDBConnection.createConnection();
        con.setAutoCommit(false); // Start transaction

        // Insert the order into the Orders table
        String sql = "INSERT INTO Orders (OrderID, OrderDate, ProductID, Qty, TotalPrice) VALUES (?, ?, ?, ?, ?)";
        pst = con.prepareStatement(sql);

        pst.setInt(1, orderid);
        pst.setDate(2, sqlcreatedate);
        pst.setInt(3, productid);
        pst.setInt(4, qty);
        pst.setInt(5, total);

        int count = pst.executeUpdate();

        // If the order was successfully added, update the product quantity
        if (count > 0) {
            String updateQtySql = "UPDATE product SET Qty = Qty - ? WHERE ProductID = ?";
            pstUpdate = con.prepareStatement(updateQtySql);

            pstUpdate.setInt(1, qty); // Deduct the ordered quantity
            pstUpdate.setInt(2, productid); // Match the product ID

            int updateCount = pstUpdate.executeUpdate();

            if (updateCount > 0) {
                con.commit(); // Commit transaction
                JOptionPane.showMessageDialog(null, "Order Added and Product Quantity Updated!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                con.rollback(); // Rollback if quantity update fails
                JOptionPane.showMessageDialog(null, "Failed to update product quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            con.rollback(); // Rollback if order insertion fails
            JOptionPane.showMessageDialog(null, "Failed to add order.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        try {
            if (con != null) {
                con.rollback(); // Rollback in case of an error
            }
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        e.printStackTrace(); // Print the exception for debugging
    } finally {
        // Close PreparedStatements and Connection to avoid memory leaks
        try {
            if (pst != null) pst.close();
            if (pstUpdate != null) pstUpdate.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

   
   public void updateOrder(Date orderdate,int productid,int qty,int total,int orderid){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE Orders SET OrderDate = ?, ProductID = ?, Qty = ?, TotalPrice = ? WHERE OrderID = ?";
            pst = con.prepareStatement(sql);
             pst.setDate(1, orderdate);
            pst.setInt(2, productid);
            pst.setInt(3, qty);
            pst.setInt(4, total);
            pst.setInt(5, orderid);
            
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Order Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                     // JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
        
        public void deleteOrder(int Orderid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Orders WHERE OrderID  = '" + Orderid + "'");
            if (count > 0) {
            } else {
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
    
    
}
