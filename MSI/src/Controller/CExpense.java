/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MExpense;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class CExpense {
    
    MExpense ce=new MExpense();
   
   public void addExpense(Date date,String discription,int amount){
       ce.addExpense(date, discription, amount);
   }
   
     public void updateExpense(int expenseid,Date date,String discription,int amount){
     ce.updateExpense(expenseid, date, discription, amount);
     }
     
     public void deleteExpense(int expenseid){
     ce.deleteExpense(expenseid);
     }
    
   

}
