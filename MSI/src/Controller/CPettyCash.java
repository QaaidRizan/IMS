/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MPetty;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class CPettyCash {
    
        MPetty mpc=new MPetty();
        
        
     public void addPettyCash(Date date,String discription,int amount){
         mpc.addPettyCash(date, discription, amount);
     }
    
        public void updatePettyCash(int pettycashid,Date date,String discription,int amount){
        mpc.updatePettyCash(pettycashid, date, discription, amount);
        }
        
        public void deletePettyCash(int pettycashid){
        mpc.deletePettyCash(pettycashid);
        }
}
