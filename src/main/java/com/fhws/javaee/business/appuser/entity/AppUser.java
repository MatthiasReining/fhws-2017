package com.fhws.javaee.business.appuser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({
    @NamedQuery(name = AppUser.FIND_ALL, query = "SELECT au FROM AppUser au"),
    @NamedQuery(name = AppUser.FIND_BY_USERNAME, query = "SELECT au FROM AppUser au WHERE au.email = :" + AppUser.PARAM_USERNAME)
})
@XmlRootElement
public class AppUser implements Serializable {

    public static final String FIND_ALL = "AppUser.findAll";
    public static final String FIND_BY_USERNAME = "AppUser.findByUserName";
    public static final String PARAM_USERNAME = "paramUserName";

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

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ChangeLog> changeLogs = new ArrayList<>();

    public List<ChangeLog> getChangeLogs() {
        return changeLogs;
    }

    public void setChangeLogs(List<ChangeLog> changeLogs) {
        this.changeLogs = changeLogs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
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

    public JsonObject toJson() {
        JsonObjectBuilder json = Json.createObjectBuilder();

        return json.add("id", id)
                .add("email", email)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .build();
    }

}
