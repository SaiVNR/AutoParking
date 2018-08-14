package com.epam.teja.file_operations;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.teja.parking_operations.ParkingOperations;

import java.util.TreeSet;



/**
 * @author Saiteja_Suggula
 *
 */
public class DataOperationServices {


    /**
     * WriteOperations Object.
     */
    private WriteOperations writeOperations;
    /**
     * ReadOperations object.
     */
    private ReadOperations readOperations;
    /**
     * Constructor.
     */
    public DataOperationServices() {
        writeOperations = new WriteOperations();
        readOperations = new ReadOperations();
    }

    /**
     * Method to store parkingSlot details to File.
     * @param filePath Path of file.
     * @throws Exception IO Exception
     */
    public void writeParkingData(final String filePath)
                       throws Exception {
        String data = (ParkingOperations.getFreeSlots().size()
                      + ParkingOperations.getCarsInParkingArea()
                        .size()
                      + System.lineSeparator());
        for (Entry<String, Integer> entry
                 : ParkingOperations.getCarsInParkingArea().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            data += key + "," + value + System.lineSeparator();


        }
        writeOperations.writeData(filePath, data, false);
    }

    /**
     * Used to reset file data.
     * @param filePath Path of file.
     * @throws Exception IO.
     */
    public void resetData(final String filePath) throws Exception {
        writeOperations.writeData(filePath, "", false);
    }


    /**
     * Used to get slots count from File.
     * @param filePath Path of file.
     * @return slots count.
     * @throws IOException IO
     */
    public int getCountOfSlots(final String filePath)
                                      throws IOException {
        int size = 0;
        String[] data = readOperations.readData(filePath).split("&&&");
        if (!data[0].equals("")) {
            size = Integer.parseInt(data[0]);
        }

        return size;
    }

    /**
     * Used to initialize data.
     * @param filePath Path of file.
     * @throws IOException IO
     */
    public void initializeSlots(final String filePath)
                                       throws IOException {
        HashMap<String, Integer> parkingData = new HashMap<String, Integer>();
        String[] data = readOperations.readData(filePath).split("&&&");
        for (int index = 1; index < data.length; index++) {
            String[] carDetails = data[index].split(",");
            parkingData.put(carDetails[0], Integer.parseInt(carDetails[1]));
        }
        ParkingOperations.setCarsInParkingArea(parkingData);
        initializeFreeSlots(parkingData, filePath);

    }

    /**
     * @param filledSlots Details of filled slots
     * @param filePath Path of file.
     * @throws IOException IO.
     */
    public void initializeFreeSlots(
                   final Map<String, Integer> filledSlots,
                   final String filePath) throws IOException {
        int totalSlotsCount = getCountOfSlots(filePath);
        TreeSet<Integer> freeSlots = new TreeSet<Integer>();
        for (int index = 0; index < totalSlotsCount; index++) {
            if (!filledSlots.containsValue(index)) {
                freeSlots.add(index);
            }
        }

        ParkingOperations.setFreeSlots(freeSlots);
    }
}

