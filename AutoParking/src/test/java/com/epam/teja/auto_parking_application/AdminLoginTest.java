package com.epam.teja.auto_parking_application;


import com.epam.teja.validators.AdminLogin;

import junit.framework.TestCase;


/**
 * Unit test for Administrator Login Check.
 */
public class AdminLoginTest
    extends TestCase {
    /**
     * Login Test :-).
     */
    public void testAppLoginPass() {
        assertTrue(new AdminLogin().validateAdmin("admin", "admin"));
    }

    /**
     * Login Test :-).
     */
    public void testAppLoginFail() {
        assertFalse(new AdminLogin().validateAdmin("admin", "teja"));
        assertFalse(new AdminLogin().validateAdmin("teja", "admin"));
        assertFalse(new AdminLogin().validateAdmin("", ""));
    }
}

