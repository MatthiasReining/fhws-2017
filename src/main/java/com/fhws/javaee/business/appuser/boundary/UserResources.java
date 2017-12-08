/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.appuser.boundary;

import com.fhws.javaee.business.appuser.entity.AppUser;
import com.fhws.javaee.business.appuser.entity.ChangeLog;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResources {

    @Inject
    AppUserService userService;

    @GET
    public List<AppUser> getAllUsers(@QueryParam("lastName") String lastName) {
        List<AppUser> allUsers = userService.getAll();
        if (lastName == null) {
            return allUsers;
        }

        //TODO search in EJB (or database)
        List<AppUser> resultList = new ArrayList<>();
        for (AppUser au : allUsers) {
            if (lastName.equalsIgnoreCase(au.getLastName())) {
                resultList.add(au);
            }
        }
        return resultList;
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") long id) {
        System.out.println("id: " + id);
        AppUser au = userService.findById(id);        
         
        return Response.ok(au.toJson().toString())
                .header("count", "1")
                .build();
    }

    @GET
    @Path("{id}/logs")
    public List<ChangeLog> getChangeLogs(@PathParam("id") long id) {
        return userService.findById(id).getChangeLogs();
    }

    @GET
    @Path("{id}/logs/{changeLogId}")
    public ChangeLog getChangeLog(@PathParam("id") long id, @PathParam("changeLogId") long changeLogId) {
        for (ChangeLog cl : userService.findById(id).getChangeLogs()) {
            if (changeLogId == cl.getId()) {
                return cl;
            }
        }
        return null;
    }

}
