/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.appuser.boundary;

import com.fhws.javaee.business.appuser.entity.AppUser;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@WebService
@Stateless
public class AppUserInfoWS {

    @PersistenceContext
    EntityManager em;

    public AppUser getById(long id) {
        AppUserService aus = new AppUserService(em, null);

        return aus.findById(id);
    }
}
