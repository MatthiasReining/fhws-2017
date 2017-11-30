/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UserController {
    
    private AppUser appUser;
    
    public String load(AppUser appUser) {
        System.out.println("app User: " + appUser.getFirstName());
        
        this.appUser = appUser;
        
        return "app-user?faces-redirect=true";
    }

    public String save() {
        System.out.println("save");
        System.out.println(this.appUser);
        
        return "";
    }
    
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
    
    
    
}
