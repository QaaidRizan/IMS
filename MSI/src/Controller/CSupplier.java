/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MSupplier;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class CSupplier {
    
    MSupplier ms=new MSupplier();
     public void addSupplier(String suppliername,int nic,String email,int phone){
         ms.addSupplier(suppliername, nic, email, phone);
     }
     
     public void updateSupplier(int Supplierid,String suppliername,int nic,String email,int phone){
         ms.updateSupplier(Supplierid, suppliername, nic, email, phone);
     }
     
     public void deleteSupplier(int Supplierid){
       
         ms.deleteSupplier(Supplierid);
       
    }
    
    
    
    
   }

