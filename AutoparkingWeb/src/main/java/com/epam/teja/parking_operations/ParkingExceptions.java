package com.epam.teja.parking_operations;

/**
 * @author Saiteja_Suggula
 *
 */
public class ParkingExceptions extends Exception {

    /**
     * @param errorMessage Error for exception.
     */
    public ParkingExceptions(final String errorMessage) {
        super(errorMessage);
    }
}
