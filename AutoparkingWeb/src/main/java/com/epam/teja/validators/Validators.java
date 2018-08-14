package com.epam.teja.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Saiteja_Suggula
 *
 */
public class Validators {

    /**
     * Constructor.
     */
    public Validators() {

    }
    /**
     * @param carNo Car Number.
     * @return validates and returns boolean
     */

    public boolean validateCarNumber(final String carNo) {
         Pattern p = Pattern.compile("[A-Z]{2}[0-9]{2}"
                              + "[A-Z]{2}[0-9]{4}");
         Matcher m = p.matcher(carNo.toUpperCase());
         return m.matches();
    }
}
