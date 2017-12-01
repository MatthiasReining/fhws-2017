/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.appuser.controller;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author matthias
 */
public class PasswordManagerTest {

    @Test
    public void testUniqueHash() {
        
        System.out.println(PasswordManager.generatePasswordHash("geheim"));
        System.out.println(PasswordManager.generatePasswordHash("geheim"));
        System.out.println(PasswordManager.generatePasswordHash("geheim"));
        System.out.println(PasswordManager.generatePasswordHash("geheim"));

        String hash1 = PasswordManager.generatePasswordHash("geheim");
        String hash2 = PasswordManager.generatePasswordHash("geheim");

        Assert.assertNotEquals(hash1, hash2);
    }

    public void checkPW() {
        String pw = "geheim";
        String hash = PasswordManager.generatePasswordHash(pw);
        
        Assert.assertTrue(PasswordManager.validatePassword(pw, hash));

    }

}
