/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MSalary;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class CSalary {
    MSalary ms=new MSalary();
    
     public void addSalary(Date sdate,int bsalary,int allowance,int employid){
     ms.addSalary(sdate, bsalary, allowance, employid);
     }
     
     public void updateSalary(int salaryid,Date sdate,int bsalary,int allowance,int employid){
     ms.updateSalary(salaryid, sdate, bsalary, allowance, employid);
     }
     
      public void deleteSalary(int salaryid){
      ms.deleteSalary(salaryid);
      }
     
     
}
