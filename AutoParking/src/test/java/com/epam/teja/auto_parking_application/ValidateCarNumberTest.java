package com.epam.teja.auto_parking_application;

import com.epam.teja.validators.Validators;

import junit.framework.TestCase;


/**
 * Unit test for Car Number validation.
 */
public class ValidateCarNumberTest
    extends TestCase {

    /**
     * Valid Number.
     */
    public void testAppValidCarNumber() {
        assertTrue(new Validators().validateCarNumber("ts07eu7639"));
        assertTrue(new Validators().validateCarNumber("AP28AV0964"));
    }

    /**
     * Invalid Number.
     */
    public void testAppInvalidCarNumber() {
        assertFalse(new Validators().validateCarNumber("t07eu7639"));
        assertFalse(new Validators().validateCarNumber("tsa7eu7639"));
        assertFalse(new Validators().validateCarNumber("aaaa"));
        assertFalse(new Validators().validateCarNumber("00000000"));
    }
}
