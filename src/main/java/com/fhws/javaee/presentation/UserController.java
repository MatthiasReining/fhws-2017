/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation;

import com.fhws.javaee.business.appuser.boundary.AppUserService;
import com.fhws.javaee.business.appuser.entity.AppUser;
import com.fhws.javaee.business.performance.boundary.KeeperOfTime;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserController implements Serializable {

    @EJB
    AppUserService aus;

    private AppUser appUser;

    public String load(AppUser appUser) {
        System.out.println("app User: " + appUser.getFirstName());
        this.appUser = appUser;
        return "app-user?faces-redirect=true";
    }

    @KeeperOfTime
    public String save() {
        aus.save(appUser);

        return "";
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

 }
