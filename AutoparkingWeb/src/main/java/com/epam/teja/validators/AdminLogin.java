package com.epam.teja.validators;

/**
 * @author Saiteja_Suggula.
 *
 */
public class AdminLogin {

    /**
     * @param userName UserName of administrator.
     * @param password Password of administrator.
     * @return validation output.
     */
    public boolean validateAdmin(final String userName, final String password) {

        if (userName.equalsIgnoreCase("Admin") && password.equals("admin")) {
           return true;
        }
        return false;
    }
}
