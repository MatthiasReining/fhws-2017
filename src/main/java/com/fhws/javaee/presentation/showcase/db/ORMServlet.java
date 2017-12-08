/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.db;

import com.fhws.javaee.business.log.controller.ORMapper;
import com.fhws.javaee.business.log.entity.LogInfo;
import java.io.IOException;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("orm")
public class ORMServlet extends HttpServlet {
    
    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    DataSource dataSource;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("in orm servlet");
        
        System.out.println(dataSource);
       
        
        LogInfo logInfo = new LogInfo();
        logInfo.setInserttime(new Date());
        logInfo.setMessage("Hallo hallo");
        ORMapper orm = new ORMapper();
        orm.save(dataSource, logInfo);
        
        
        
    }
}
