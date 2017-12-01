/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.appuser.boundary;

import com.fhws.javaee.business.appuser.controller.PasswordManager;
import com.fhws.javaee.business.appuser.entity.AppUser;
import com.fhws.javaee.business.appuser.entity.ChangeLog;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class AppUserService {

    EntityManager em;
    UserTransaction ut;

    public AppUserService(EntityManager em, UserTransaction ut) {
        this.em = em;
        this.ut = ut;
    }

    public AppUser checkLogin(String username, String password) {

        try {
            ut.begin();

            AppUser user = em.createNamedQuery(AppUser.FIND_BY_USERNAME, AppUser.class)
                    .setParameter(AppUser.PARAM_USERNAME, username)
                    .getSingleResult();
            System.out.println(user);
            String dbPassword = user.getPassword();
            if (PasswordManager.validatePassword(password, dbPassword)) {
                user.setLastLogin(new Date());
                user.setLoginFailed(0);
                ut.commit();

            } else {
                Integer loginFailed = user.getLoginFailed();
                if (loginFailed == null) {
                    loginFailed = 0;
                }
                loginFailed++;
                user.setLoginFailed(loginFailed);
                ut.commit();
                return null;
            }
            return user;
        } catch (NoResultException e) {
            return null;
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            throw new RuntimeException(ex);
        }
    }

    public AppUser save(AppUser appUser, String currentUser) {
        try {
            ut.begin();

            appUser = em.merge(appUser);
            //appUser is now managed

            ChangeLog cl = new ChangeLog();
            cl.setAppUser(appUser);
            cl.setUsername(currentUser);

            appUser.getChangeLogs().add(cl);

            ut.commit();

            return appUser;
        } catch (RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | NotSupportedException | SystemException ex) {
            throw new RuntimeException(ex);
        }
    }

    public AppUser findById(long id) {
        return em.find(AppUser.class, id);
    }

    public List<AppUser> getAll() {
        return em.createNamedQuery(AppUser.FIND_ALL, AppUser.class).getResultList();
    }
}
