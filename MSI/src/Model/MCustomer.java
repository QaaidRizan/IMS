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
public class MCustomer {
    
     public void addCustomer(String name,String nic,int phone,String address){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "INSERT INTO Customer (Name,NIC,Phone,Address) VALUES ( ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setString(1,name);
            pst.setString(2, nic);
            pst.setInt(3, phone);
            pst.setString(4, address);
            

            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Customer Added !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
        }
        
    }
   
   public void updateCustomer(int Customerid,String name,String nic,int phone,String address){
       
       Connection con;
     PreparedStatement pst = null;
     
        try{ 
            
            con = MDBConnection.createConnection();
            
            String sql = "UPDATE Customer SET Name = ?, NIC = ?, Phone = ?, Address = ? WHERE CustomerID = ?";
            pst = con.prepareStatement(sql);

            pst.setString(1,name);
            pst.setString(2, nic);
            pst.setInt(3, phone);
            pst.setString(4, address);
            pst.setInt(5, Customerid);
            
            
            int count = pst.executeUpdate();

            if(count>0){
                JOptionPane.showMessageDialog(null, "Customer Updated !", "information",JOptionPane.INFORMATION_MESSAGE);
        }
        }
         catch(SQLException e)
                 {
                     
                     // JOptionPane.showMessageDialog(null, "Something went wrong !", "information",JOptionPane.INFORMATION_MESSAGE);
                     
        }
   }
        
        public void deleteCutomer(int Customerid)
     {
             try {
            Statement st = MDBConnection.createConnection().createStatement();
            int count = st.executeUpdate("DELETE FROM Customer WHERE CustomerID  = '" + Customerid + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Customer deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Customer found with ID " + Customerid, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
     }
    
    

}
