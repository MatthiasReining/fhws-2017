/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.appuser.boundary;

import com.fhws.javaee.business.appuser.controller.PasswordManager;
import com.fhws.javaee.business.appuser.entity.AppUser;
import com.fhws.javaee.business.appuser.entity.ChangeLog;
import com.fhws.javaee.business.news.boundary.NewsLogin;
import com.fhws.javaee.business.performance.boundary.KeeperOfTime;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class AppUserService {

    @PersistenceContext
    EntityManager em;
    
    @Inject @CurrentUser
    AppUser currentUser;
    
    @Inject @NewsLogin
    Event<String> newsEvent;

    @KeeperOfTime
    public AppUser checkLogin(String username, String password) {
        try {
            AppUser user = em.createNamedQuery(AppUser.FIND_BY_USERNAME, AppUser.class)
                    .setParameter(AppUser.PARAM_USERNAME, username)
                    .getSingleResult();
            System.out.println(user);
            String dbPassword = user.getPassword();
            if (PasswordManager.validatePassword(password, dbPassword)) {
                user.setLastLogin(new Date());
                user.setLoginFailed(0);
                
                newsEvent.fire("User " + user.getFirstName() + " " + user.getLastName() + " is logged in!");
                
            } else {
                Integer loginFailed = user.getLoginFailed();
                if (loginFailed == null) {
                    loginFailed = 0;
                }
                loginFailed++;
                user.setLoginFailed(loginFailed);
                return null;
            }
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    public AppUser save(AppUser appUser) {
        appUser = em.merge(appUser);
        //appUser is now managed

        ChangeLog cl = new ChangeLog();
        cl.setAppUser(appUser);
        cl.setUsername(currentUser.getEmail());

        appUser.getChangeLogs().add(cl);
        return appUser;
    }

    public AppUser findById(long id) {
        return em.find(AppUser.class, id);
    }

    public List<AppUser> getAll() {
        return em.createNamedQuery(AppUser.FIND_ALL, AppUser.class).getResultList();
    }
}
