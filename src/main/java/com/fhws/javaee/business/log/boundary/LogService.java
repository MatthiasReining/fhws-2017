/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.log.boundary;

import com.fhws.javaee.business.log.entity.JPALog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LogService {

    @PersistenceContext
    EntityManager em;

    public void log(String message) {
        JPALog log = new JPALog();
        log.setMessage(message);
        em.merge(log);
    }

}
