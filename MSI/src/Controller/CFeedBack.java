/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MFeedBack;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class CFeedBack {
        MFeedBack mf=new MFeedBack();
    public void addFeedback(Date date,String discriptionint,int employeid,String employename){
        mf.addFeedback(date, discriptionint, employeid, employename);
    }
    
     public void updateFeedback(int feedbackid,Date date,String discriptionint,int employeid,String employename){
         mf.updateFeedback(feedbackid, date, discriptionint, employeid, employename);
     }
      public void deleteFeedback(int feedbackid){
          mf.deleteFeedback(feedbackid);
      }
}
