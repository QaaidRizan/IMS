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
public class MSupplier {
    
     public void addSupplier(String suppliername,int nic,String email,int phone){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO  supplier (SupplierName, NIC ,Email, Phone) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, suppliername);
            pst.setInt(2, nic);
            pst.setString(3, email);
            pst.setInt(4, phone);
           
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "supplier Ditails Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
     
     public void updateSupplier(int Supplierid,String suppliername,int nic,String email,int phone){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE supplier SET SupplierName = ?, NIC = ?, Email = ?, Phone = ? WHERE SupplierID = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, suppliername);
            pst.setInt(2, nic);
            pst.setString(3, email);
            pst.setInt(4, phone);
            pst.setInt(5, Supplierid);
            
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Supplier Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                      JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
     
     public void deleteSupplier(int Supplierid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM supplier WHERE SupplierID  = '" + Supplierid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Supplierid deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Supplierid found with ID " + Supplierid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
    
}
