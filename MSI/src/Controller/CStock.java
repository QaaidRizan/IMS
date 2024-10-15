/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MStock;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class CStock {
    MStock ms=new MStock();
    public void addStock(int qty,int productid,int supplierid,Date sqlStockDate,int price){
    
    ms.addStock(qty, productid, supplierid, sqlStockDate, price);
    }
    
     public void updateStock(int stockid, int qty,int productid,int supplierid,Date sqlStockDate){
     ms.updateStock(stockid, qty, productid, supplierid, sqlStockDate);
     }
     
      public void deleteSupplier(int stockid){
      ms.deleteSupplier(stockid);
      }
    
}
