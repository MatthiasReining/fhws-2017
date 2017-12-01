package com.fhws.javaee.business.appuser.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class ChangeLog implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @XmlTransient
    private AppUser appUser;

    private String username;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ts;

    @PrePersist
    public void preSave() {
        ts = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlTransient
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

}
