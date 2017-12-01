package com.fhws.javaee.presentation;

import com.fhws.javaee.business.appuser.boundary.AppUserService;
import com.fhws.javaee.business.appuser.entity.AppUser;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
@SessionScoped
public class LoginController {

    @EJB
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
