/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MProduct {
    
   public void addProduct(String productname,int price,Date sqlcreatedate,Date sqlmodifydate,Date sqlwarantydate,int qty){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO Product (ProductName, Price, CreateDate, ModifyDate, Warranty_Date,Qty) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, productname);
            pst.setInt(2, price);
            pst.setDate(3, sqlcreatedate);
            pst.setDate(4, sqlmodifydate);
            pst.setDate(5, sqlwarantydate);
            pst.setInt(6, qty);
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Product Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
   
   public void updateProduct(int productid,String productname,int price,Date sqlcreatedate,Date sqlmodifydate,Date sqlwarantydate){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE Product SET ProductName = ?, price = ?, CreateDate = ?, ModifyDate = ?, Warranty_Date = ? WHERE ProductID = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, productname);
            pst.setInt(2, price);
            pst.setDate(3, sqlcreatedate);
            pst.setDate(4, sqlmodifydate);
            pst.setDate(5, sqlwarantydate);
            pst.setInt(6, productid);
            
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
        
        public void deleteProduct(int productid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Product WHERE ProductID  = '" + productid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Product deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No productid found with ID " + productid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }

        
    }
       
       
   
    

