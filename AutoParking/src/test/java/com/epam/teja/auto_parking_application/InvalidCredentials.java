package com.epam.teja.auto_parking_application;



import junit.framework.TestCase;

import com.epam.teja.parking_operations.ParkingExceptions;

/**
 * @author Saiteja_Suggula
 *
 */
public class InvalidCredentials extends TestCase {
     /**
     * @throws Exception Invalid Credentials Exception.
     */
    public void testInvalidCredentials() throws Exception {
         boolean thrown = false;
         try {
            App app = new App();
            App.main(new String[] {"admin", "root"});
         } catch (ParkingExceptions e) {
               thrown = true;
         }

         assertTrue(thrown);
     }
}
