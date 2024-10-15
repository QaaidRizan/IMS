/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MProduct;
import java.sql.*;

/**
 *
 * @author USER
 */
public class CProduct {
               MProduct mp=new MProduct();

    public void addProduct(String productname,int price,Date sqlcreatedate,Date sqlmodifydate,Date sqlwarantydate,int qty){
       mp.addProduct(productname, price, sqlcreatedate, sqlmodifydate, sqlwarantydate, qty);
   }
    
    public void updateProduct(int productid,String productname,int price,Date sqlcreatedate,Date sqlmodifydate,Date sqlwarantydate){
        mp.updateProduct(productid, productname, price, sqlcreatedate, sqlmodifydate, sqlwarantydate);
    } 
    
    public void deleteProduct(int productid){
     mp.deleteProduct(productid);
 }
}
