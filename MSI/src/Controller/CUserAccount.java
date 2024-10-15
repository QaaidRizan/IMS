/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MUserAccount;import java.util.*;

import java.sql.Date;


/**
 *
 * @author USER
 */
public class CUserAccount {
    MUserAccount mua=new MUserAccount(); 
    public void registerUser(int userid,String username,String password1,String fullname,String fname,String lname,String loaction,String mail,Date sqlCreateDate,int phoneNumber,Date dateofbirth,String role){
    mua.registerUser(userid, username, password1, fullname, fname, lname, loaction, mail, sqlCreateDate, phoneNumber, dateofbirth,role);
     }

 public void deleteUser(int User_Id){
     mua.deleteUser(User_Id);
 }
 
 public void updateMember(int userid,String username,String password1,String fullname,String fname,String lname,String loaction,String mail,Date sqlCreateDate,int phoneNumber,Date dateofbirth,String role) {
      mua.updateMember(userid, username, password1, fullname, fname, lname, loaction, mail, sqlCreateDate, phoneNumber, dateofbirth, role);  
       }
}