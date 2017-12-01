/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;
import javax.transaction.NotSupportedException;
import javax.transaction.UserTransaction;

@ManagedBean
public class BadSQLController {
    
    @Resource(lookup = "java:jboss/datasources/FHWS-DS")
    DataSource datasource;
    
    @Resource
    UserTransaction ut;
    
    private String data;
    
    public void save() throws Exception {
        System.out.println("data:" + data);
        
        Connection connection = datasource.getConnection();
        
        //FIXME it's evil. SQL Injection possible
        //TODO: test with ==> wert2'); delete from test where value <> ('x
        //String sql = "INSERT INTO test(id, value) VALUES( hibernate_sequence.nextval, '" + data + "')";
        //ut.begin();
        //connection.createStatement().execute(sql);
        //ut.commit();       
        
        String sql = "INSERT INTO test(id, value) VALUES( hibernate_sequence.nextval, ?)";
        
        PreparedStatement pstmt = connection.prepareStatement(sql);
        System.out.println("SQL Statement: " + sql);
        pstmt.setString(1, data);
        
        ut.begin();
        pstmt.execute();
        ut.commit();
        
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
}
