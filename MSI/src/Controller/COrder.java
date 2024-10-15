/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MOrder;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class COrder {
    
        MOrder mo=new MOrder();
       
      public void addOrder(int orderid,Date sqlcreatedate,int productid,int qty,int total){
      mo.addOrder(orderid, sqlcreatedate, productid, qty, total);
      
      }
      
        public void updateOrder(Date sqlcreatedate,int productid,int qty,int total, int orderid){
        mo.updateOrder(sqlcreatedate, productid, qty,total,orderid);
        }
        
        public void deleteOrder(int Orderid){
        mo.deleteOrder(Orderid);
        }
}
