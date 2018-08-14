package com.epam.teja.auto_parking_application;

import junit.framework.TestCase;

import com.epam.teja.parking_operations.ParkingOperations;
import com.epam.teja.parking_operations.ParkingExceptions;

/**
 * Unit test for Parking Exit.
 */
public class ParkingExitTest
    extends TestCase {

    /**
     * Parking Exit Pass Case :-).
     * @throws Exception Multiple Exceptions.
     */
    public void testAppPossibleExit() throws Exception {
        final int slotSize = 3;
        ParkingOperations parkingOperations =
                ParkingOperations.getInstance(slotSize);
        assertTrue(parkingOperations.park("ts07eu7639"));
        assertTrue(parkingOperations.park("ts07ew7639"));
        assertTrue(parkingOperations.unPark("ts07eu7639"));
    }

    /**
     * Car not found Case :-).
     * @throws Exception Multiple Exceptions.
     */
    public void testAppNotPossibleExitCarNotFound() throws Exception {
        boolean thrown = false;
        try {
            final int slotSize = 3;
            ParkingOperations parkingOperations =
                    ParkingOperations.getInstance(slotSize);
            assertTrue(parkingOperations.park("ts07eu7639"));
            assertTrue(parkingOperations.park("ts07ew7639"));
            assertFalse(parkingOperations.unPark("ap07eu7639"));
        } catch (ParkingExceptions e) {
              thrown = true;
        }

        assertTrue(thrown);
    }

    /**
     * Car Not Possible to Enter Test Because of Invalid number :-).
     * @throws Exception Multiple Exceptions.
     */
    public void testAppNotPossibleExitInvalidCarNumber() throws Exception {
        boolean thrown = false;
        try {
            final int slotSize = 3;
            ParkingOperations parkingOperations =
                    ParkingOperations.getInstance(slotSize);
            assertTrue(parkingOperations.park("ts07eu7639"));
            assertTrue(parkingOperations.park("ts07ew7639"));
            assertFalse(parkingOperations.unPark("07eu7639"));
        } catch (ParkingExceptions e) {
              thrown = true;
        }

        assertTrue(thrown);
    }
}


