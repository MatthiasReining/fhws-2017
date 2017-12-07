package com.fhws.javaee.presentation.showcase.ejb;

import com.fhws.javaee.business.log.entity.JPALog;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJBTest1 {

    @PersistenceContext
    EntityManager em;

    @EJB
    EJBTest2 ejb2;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public JPALog m1() {
        JPALog log = new JPALog();
        log.setData1("in EJBTest1#m1");

        ejb2.m2();

        System.out.println(42 / 0);

        return em.merge(log);
    }

}
