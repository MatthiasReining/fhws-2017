package com.fhws.javaee.presentation;

import com.fhws.javaee.business.appuser.boundary.AppUserService;
import com.fhws.javaee.business.appuser.entity.AppUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class UserListController {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction ut;

    AppUserService aus;
    
    @PostConstruct
    void init() {
        aus = new AppUserService(em, ut);
    }
  
    public List<AppUser> getUsers() {
        return aus.getAll();
    }

}
