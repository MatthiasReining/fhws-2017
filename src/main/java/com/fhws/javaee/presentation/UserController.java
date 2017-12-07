/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation;

import com.fhws.javaee.business.appuser.boundary.AppUserService;
import com.fhws.javaee.business.appuser.entity.AppUser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UserController implements Serializable {

    @Inject
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
