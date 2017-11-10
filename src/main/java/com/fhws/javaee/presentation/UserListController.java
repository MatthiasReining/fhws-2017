package com.fhws.javaee.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserListController {

    List<AppUser> users;
        
    @PostConstruct
    public void init() {
        users = new ArrayList<>();
        
        users.add(new AppUser("mickey.mouse@disney.com", "topsecret", "Mickey", "Mouse"));
        users.add(new AppUser("mini.mouse@disney.com", "topsecret", "Mini", "Mouse"));
        users.add(new AppUser("donald.duck@disney.com", "topsecret", "Donald", "Duck"));
        users.add(new AppUser("daisy.duck@disney.com", "topsecret", "Daisy", "Duck"));       
        
    }

    public List<AppUser> getUsers() {
        return users;
    }
   

}
