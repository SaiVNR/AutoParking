package com.epam.teja.auto_parking_application;

import junit.framework.TestCase;

import com.epam.teja.parking_operations.ParkingOperations;
import com.epam.teja.parking_operations.ParkingExceptions;

/**
 * Unit test for Parking Entry.
 */
public class ParkingEntryTest
    extends TestCase {

    /**
     * Car Possible to Enter Test :-).
     * @throws Exception Multiple Exceptions.
     */
    public void testAppPossibleEntry() throws Exception {
        final int slotSize = 3;
        ParkingOperations parkingOperations =
                ParkingOperations.getInstance(slotSize);
        assertTrue(parkingOperations.park("ts07eu7639"));
        assertTrue(parkingOperations.park("ts07ew7639"));
    }

    /**
     * Car Not Possible to Enter Test.
     * @throws Exception Multiple Exceptions.
     */
    public void testAppNotPossibleEntry() throws Exception {
        boolean thrown = false;
        try {
            final int slotSize = 3;
            ParkingOperations parkingOperations =
                    ParkingOperations.getInstance(slotSize);
            assertTrue(parkingOperations.park("ts07eu7639"));
            assertTrue(parkingOperations.park("ts07ew7639"));
            assertTrue(parkingOperations.park("ts07er7639"));
            assertFalse(parkingOperations.park("as07ew7639"));
        } catch (ParkingExceptions e) {
              thrown = true;
        }

        assertTrue(thrown);
    }
    /**
     * Car Not Possible to Enter Test Because of Invalid number :-).
     * @throws Exception Multiple Exceptions.
     */
    public void testAppNotPossibleEntryInvalidCarNo() throws Exception {
          boolean thrown = false;

          try {
              final int slotSize = 3;
              ParkingOperations parkingOperations =
                      ParkingOperations.getInstance(slotSize);
              parkingOperations.park("a07ew7639");
          } catch (ParkingExceptions e) {
                thrown = true;
          }

          assertTrue(thrown);
    }

    /**
     * Test for Display of car details :-).
     * @throws Exception Multiple Exceptions.
     */
    public void testDisplay() throws Exception {
        final int slotSize = 3;
        ParkingOperations parkingOperations =
                ParkingOperations.getInstance(slotSize);
        assertTrue(parkingOperations.park("ts07eu7639"));
        assertTrue(parkingOperations.displayStatusOfLobby());
    }
}


