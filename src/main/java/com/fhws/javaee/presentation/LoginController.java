package com.fhws.javaee.presentation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginController {

    private AppUser user;
    
    @PostConstruct
    public void init() {
        user = new AppUser();
    }
    

    public String login() {
        System.out.println("in login");

        System.out.println("login " + user.getEmail() + "/" + user.getPassword());
        
        if ("admin".equalsIgnoreCase(user.getPassword())) {
            return "app-user-list.xhtml?faces-redirect=true";
        }
        return "login";
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

}
