package com.epam.teja.parking_operations;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.epam.teja.file_operations.Log;
import com.epam.teja.validators.Validators;


/**
 * @author Saiteja_Suggula.
 *
 */
public final class ParkingOperations {

    /**
     * Cars array.
     */
    private static TreeSet<Integer> freeSlots;

    /**
     * Stores Parking Details.
     */
    private static HashMap<String, Integer> carsInParkingArea;


    /**
     * Constructor.
     * @param numberOfSlots Indicates number of slots.
     */
    private ParkingOperations(final Integer numberOfSlots) {
        Log.d("Initialization ", "Done successfully");
        freeSlots = new TreeSet<>();
        carsInParkingArea = new HashMap<String, Integer>();
        for (int i = 0; i < numberOfSlots; i++) {
            freeSlots.add(i);
        }
    }


    /**
     * @param size number of slots.
     * @return Parking Operations object.
     */
    public static ParkingOperations getInstance(final int size) {
        return new ParkingOperations(size);
    }

    /**
     * Method to add a car to parking Lobby.
     * @param carNumber Car Number.
     * @throws Exception Multiple.
     * @return Car can be parked or not.
     */
    public boolean park(final String carNumber) throws Exception {
        boolean isParkingDone = false;
        if (carsInParkingArea.containsKey(carNumber)) {
            Log.e("Unable to park ", "Car already in the lobby!!!");
            throw new ParkingExceptions("Car already in lobby");
        } else {
            if (freeSlots.isEmpty()) {
                Log.e("Unable to park ", "Parking area full!!!");
                throw new ParkingExceptions("Parking full!!!");
            } else {
                if (new Validators().validateCarNumber(carNumber)) {
                    int slotNumber = freeSlots.first();
                    carsInParkingArea.put(carNumber, slotNumber);
                    freeSlots.remove(slotNumber);
                    Log.d("Car parked ", carNumber);
                    Log.d("Slot number", (slotNumber + 1) + "");
                    isParkingDone = true;
                } else {
                    Log.e("Unable to park ", "Invalid car number format!");
                    throw new ParkingExceptions("Invalid car number format!");
                }
            }
        }
        return isParkingDone;
    }

    /**
     * Method to remove a car to parking Lobby.
     * @param carNumber Car Number.
     * @throws Exception Multiple.
     * @return Car can exit or not.
     */
    public boolean unPark(final String carNumber) throws Exception {
        boolean isExitDone = false;
        if (new Validators().validateCarNumber(carNumber)) {
            if (carsInParkingArea.containsKey(carNumber)) {
                 int slot = carsInParkingArea.get(carNumber);
                 freeSlots.add(slot);
                 carsInParkingArea.remove(carNumber);
                 Log.d("Car unparked ", carNumber);
                 Log.d("Slot number", (slot + 1) + "");
                 isExitDone = true;
            } else {
                 Log.e("Unable to unpark ", "Please check the number.."
                                        + " Car is not in the Lobby");
                 throw new ParkingExceptions("Please check the number.."
                                  + " Car is not in the Lobby");
            }
        } else {
            Log.e("Unable to unpark ", "Invalid car number format!");
            throw new ParkingExceptions("Invalid car number format!");
        }
        return isExitDone;
    }

    /**
     * Method to display parked vehicles.
     * @return Contains cars or not.
     */
    public boolean displayStatusOfLobby() {
        boolean containsData = false;
        if (!carsInParkingArea.isEmpty()) {
            containsData = true;
            for (String key : carsInParkingArea.keySet()) {
                System.out.println("Slot number: "
                                  + (carsInParkingArea.get(key) + 1)
                                  + " Vehicle number: " + key);
            }
        }
        return containsData;
    }

    /**
     * @return Free Slots data.
     */
    public static TreeSet<Integer> getFreeSlots() {
        return freeSlots;
    }

    /**
     * @param freeSlotsData Free slots data.
     */
    public static void setFreeSlots(final TreeSet<Integer> freeSlotsData) {
        ParkingOperations.freeSlots = freeSlotsData;
    }

    /**
     * @return carsInParkingArea
     */
    public static Map<String, Integer> getCarsInParkingArea() {
        return carsInParkingArea;
    }

    /**
     * @param carsInParking carsDetails.
     */
    public static void setCarsInParkingArea(
                       final HashMap<String, Integer> carsInParking) {
        ParkingOperations.carsInParkingArea = carsInParking;
    }

}
