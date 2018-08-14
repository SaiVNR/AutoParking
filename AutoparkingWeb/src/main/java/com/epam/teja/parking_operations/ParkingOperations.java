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

	private static Integer totalSlotSize;
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
    	totalSlotSize = numberOfSlots;
        Log.d("Initialization ", "Done successfully");
        freeSlots = new TreeSet<Integer>();
        carsInParkingArea = new HashMap<String, Integer>();
        for (int i = 0; i < numberOfSlots; i++) {
            freeSlots.add(i);
        }
    }


    public static Integer getTotalSlotSize() {
		return totalSlotSize;
	}


	public static void setTotalSlotSize(Integer totalSlotSize) {
		ParkingOperations.totalSlotSize = totalSlotSize;
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
	public int park(final String carNumber) throws Exception {
		int allocatedSlot = -1;
		if (!carsInParkingArea.containsKey(carNumber)) {
			int slotNumber = freeSlots.first();
			carsInParkingArea.put(carNumber, slotNumber);
			freeSlots.remove(slotNumber);
			Log.d("Car parked ", carNumber);
			Log.d("Slot number", (slotNumber + 1) + "");
			allocatedSlot = slotNumber + 1;
		}
		return allocatedSlot;
	}

    /**
     * Method to remove a car to parking Lobby.
     * @param carNumber Car Number.
     * @throws Exception Multiple.
     * @return Car can exit or not.
     */
	public boolean unPark(final String carNumber) throws Exception {
		boolean isExitDone = false;

		if (carsInParkingArea.containsKey(carNumber)) {
			int slot = carsInParkingArea.get(carNumber);
			freeSlots.add(slot);
			carsInParkingArea.remove(carNumber);
			Log.d("Car unparked ", carNumber);
			Log.d("Slot number", (slot + 1) + "");
			isExitDone = true;
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
