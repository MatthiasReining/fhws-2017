/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = JPALog.FIND_ALL, query = "SELECT l FROM JPALog l")
})
@Table(name = "JPA_LOG")
public class JPALog implements Serializable {
    
    public final static String FIND_ALL = "JPALog.findAll";

    @Id
    @GeneratedValue
    private long id;

    private Date insertTime;
    private String data1;
    private String message;

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JPALog{" + "id=" + id + ", insertTime=" + insertTime + ", data1=" + data1 + ", message=" + message + '}';
    }
    
    

}
