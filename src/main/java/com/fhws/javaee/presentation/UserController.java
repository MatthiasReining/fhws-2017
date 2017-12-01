/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation;

import com.fhws.javaee.business.appuser.boundary.AppUserService;
import com.fhws.javaee.business.appuser.entity.AppUser;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
@SessionScoped
public class UserController {

    @ManagedProperty(value = "#{loginController}")
    private LoginController loginController;

    @EJB
    AppUserService aus;

    private AppUser appUser;

    public String load(AppUser appUser) {
        System.out.println("app User: " + appUser.getFirstName());
        this.appUser = appUser;
        return "app-user?faces-redirect=true";
    }

    public String save() {
        String currentUserName = "-";
        if (loginController != null) {
            currentUserName = loginController.getCurrentUser().getEmail();
        }
        aus.save(appUser, currentUserName);

        return "";
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

}
