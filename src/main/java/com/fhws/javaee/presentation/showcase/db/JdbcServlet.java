/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("jdbc")
public class JdbcServlet extends HttpServlet {
    
    @Resource(lookup = "java:jboss/datasources/FHWS-DS")
    DataSource dataSource;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("in jdbc servlet");
        
        System.out.println(dataSource);
        
        PrintWriter writer = resp.getWriter();
        
        try {
            Connection connection = dataSource.getConnection();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, value FROM test");
            while(rs.next()) {
                
                long id = rs.getLong("id");
                String value = rs.getString("value");
                
                writer.println("id: " + id + "; value: " + value);               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
