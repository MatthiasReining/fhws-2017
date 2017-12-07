package com.fhws.javaee.presentation;

import com.fhws.javaee.business.appuser.boundary.AppUserService;
import com.fhws.javaee.business.appuser.boundary.CurrentUser;
import com.fhws.javaee.business.appuser.entity.AppUser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    AppUserService aus;

    private AppUser currentUser;

    private String email;
    private String password;

    public String login() {
        System.out.println("in login");

        System.out.println("login " + email + "/" + password);

        currentUser = aus.checkLogin(email, password);
        if (currentUser != null) {
            return "app-user-list.xhtml?faces-redirect=true";
        }

        return "login";
    }
    

    @Produces @CurrentUser @Named
    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
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

}
