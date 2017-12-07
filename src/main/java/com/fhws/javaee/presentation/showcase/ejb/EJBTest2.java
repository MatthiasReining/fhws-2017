package com.fhws.javaee.presentation.showcase.ejb;

import com.fhws.javaee.business.log.entity.JPALog;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJBTest2 {
    
    @PersistenceContext
    EntityManager em;
        
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public JPALog m2() {
        JPALog log = new JPALog();
        log.setData1("in EJBTest2#m2");
        
        return em.merge(log);        
    }
}
