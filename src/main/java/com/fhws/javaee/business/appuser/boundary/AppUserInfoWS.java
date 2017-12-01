/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.appuser.boundary;

import com.fhws.javaee.business.appuser.entity.AppUser;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService
@Stateless
public class AppUserInfoWS {

    @EJB
    AppUserService aus;

    public AppUser getById(long id) {       
        return aus.findById(id);
    }
}
