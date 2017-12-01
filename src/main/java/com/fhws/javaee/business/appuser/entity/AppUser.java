package com.fhws.javaee.business.appuser.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = AppUser.FIND_ALL, query = "SELECT au FROM AppUser au")
})
public class AppUser implements Serializable {
    
    public static final String FIND_ALL = "AppUser.findAll";
    
    @Id
    @GeneratedValue
    private long id;
    
    private String email;
    private String password;

    @Size(min = 2)
    private String firstName;
    private String lastName;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastLogin;
    
    private Integer loginFailed;
   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getLoginFailed() {
        return loginFailed;
    }

    public void setLoginFailed(Integer loginFailed) {
        this.loginFailed = loginFailed;
    }

    
    
    @Override
    public String toString() {
        return "AppUser{" + "email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    
}
