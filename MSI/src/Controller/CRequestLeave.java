/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MRequestLeave;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class CRequestLeave {
        MRequestLeave mrl=new MRequestLeave();
    public void addLeave(int employeid,String name,Date startdate,Date enddate,String reson){
    mrl.addLeave(employeid,startdate, enddate, reson);
    }
    
      public void updateLeave(int leaveid,int employeid,String name,Date startdate,Date enddate,String reson){
      mrl.updateLeave(leaveid, employeid, startdate, enddate, reson);
      }
      
      public void deleteLeave(int leaveid){
      mrl.deleteLeave(leaveid);
      }
}
