/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.db;

import com.fhws.javaee.business.log.entity.JPALog;
import com.fhws.javaee.business.appuser.entity.AppUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet("jpa")
public class JPAServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction ut;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();

        String action = req.getParameter("action");
        if (action == null) {
            action = "read";
        }

        if ("read".equalsIgnoreCase(action)) {
            List<JPALog> list = em.createNamedQuery(JPALog.FIND_ALL, JPALog.class).getResultList();
            for (JPALog log : list) {
                writer.println(log);
            }
        } else if ("find".equalsIgnoreCase(action)) {

            Long id = Long.parseLong(req.getParameter("id"));
            JPALog log = em.find(JPALog.class, id);

            writer.println(log);

        } else if ("create".equalsIgnoreCase(action)) {
            JPALog log = new JPALog();
            log.setInsertTime(new Date());
            log.setMessage("Hallo hallo");
            try {
                ut.begin();
                em.persist(log);
                ut.commit();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                Logger.getLogger(JPAServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            writer.println("Action " + action + " is unknown!");
        }

    }

}
