/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.entities;

import java.util.Date;

/**
 *
 * @author hp
 */
public class User {
    
     private  int id;
     private String name , email ,password ,role ,token ,username ;
     private Boolean isActive;
     private Date createdAt ,updatedAt ,activatedAt ;
     protected   String captchaCode;
     
     
     
     //Constructor//////////////////
   
    public User() {
    }

    
    /*public User(int id, String name, String email, String password, String role, String token, Boolean isActive, Date createdAt, Date updatedAt, Date activatedAt, String captchaCode ,String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.token = token;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.activatedAt = activatedAt;
        this.captchaCode = captchaCode;
        this.username = username;
    }*/
/*
    public User(String name, String email, String password, String role, String token, Boolean isActive, Date createdAt, Date updatedAt, Date activatedAt, String captchaCode,String username) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.token = token;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.activatedAt = activatedAt;
        this.captchaCode = captchaCode;
        this.username = username;
    }*/

    public User( String mail,String username) {
      
        this.email = mail;
        this.role = username;
    }
    
 public User( String email,String username , String password ) {
      
        this.email = email;
        this.username = username;
         this.password = password;
    }

     
/* public User( String username,String password ) {
      
        this.username = username;
         this.password = password;
    }
   */ 
  //geters and sters//  
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(Date activatedAt) {
        this.activatedAt = activatedAt;
    }

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + '}';
    }
     
     
     
}
