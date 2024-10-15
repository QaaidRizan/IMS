/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MCustomer;

/**
 *
 * @author USER
 */
public class CCustomer {
    
                MCustomer mc=new MCustomer();
    
      public void addCustomer(String name,String nic,int phone,String address){
      mc.addCustomer(name, nic, phone, address);
      }
      
      public void updateCustomer(int Customerid,String name,String nic,int phone,String address){
      mc.updateCustomer(Customerid, name, nic, phone, address);
      }
      
        public void deleteCustomer(int Customerid){
        mc.deleteCutomer(Customerid);
        }
      
      
      
}
