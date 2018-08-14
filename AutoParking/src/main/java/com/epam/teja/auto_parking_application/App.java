package com.epam.teja.auto_parking_application;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import com.epam.teja.file_operations.DataOperationServices;
import com.epam.teja.file_operations.Log;
import com.epam.teja.validators.AdminLogin;

import com.epam.teja.parking_operations.ParkingOperations;
import com.epam.teja.parking_operations.ParkingExceptions;

/**
 * Driver Class!
 *
 */
public final class App {



    /**
     * File path.
     */
    private static String filePath = "src\\main\\details.txt";


    /**
     * @param pathOfFile Path of file.
     */
    public static void setFilePath(final String pathOfFile) {
        filePath = pathOfFile;
    }


    /**
     * Reader Object.
     */
    private static BufferedReader scanner;
    /**
     * Constructor.
     */
    protected App() {
        filePath = "src\\main\\details.txt";
    }


    /**
     * @param args Standard Input.
     * @throws Exception IO-Exception.
     */
    public static void main(final String[] args) throws Exception {

        /**Entry. */
        final int enterLobby = 1;

        /**Exit. */
        final int exitLobby = 2;

        /**Logout Administrator. */
        final int logoutAdmin = 4;

        /**STATUS_LOBBY. */
        final int statusOfLobby = 3;

        DataOperationServices dataOperationServices
                              = new DataOperationServices();


        int slotsCount = dataOperationServices.getCountOfSlots(filePath);
        ParkingOperations parkingOperations;


        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        scanner = new BufferedReader(inputStreamReader);
        System.out.println("Hello!");
        boolean loop = true;
        String userName = args[0];
        String password = args[1];
        if (new AdminLogin().validateAdmin(userName, password)) {
            Log.d("Login Status", "pass");
            System.out.println("Hello " + userName);
            if (slotsCount == 0) {
                System.out.println("Enter total number of Car Slots");
                slotsCount = Integer.parseInt(scanner.readLine());
                parkingOperations =
                        ParkingOperations.getInstance(slotsCount);
            } else {
                parkingOperations =
                        ParkingOperations.getInstance(slotsCount);
                dataOperationServices.initializeSlots(filePath);
            }
            do {
                try {
                   System.out.println("Choose your operation ");
                   System.out.println("1. Entry\n2. Exit\n"
                                     + "3. Status of Lobby"
                                     + "\n4. Logout");
                   Integer opt = Integer.parseInt(scanner.readLine());
                   switch (opt) {
                        case enterLobby :
                                Log.d("Option", "Park car");
                                System.out.println("Enter car"
                                        + " number without spaces");
                                String carNumber = scanner.readLine()
                                                          .toUpperCase();
                                if (parkingOperations.park(carNumber)) {
                                    System.out.println("Success");
                                    dataOperationServices
                                                .writeParkingData(filePath);
                                }
                                break;
                        case exitLobby :
                                Log.v("Option", "Unpark car");
                                System.out.println("Enter car"
                                    + " number without spaces");
                                String carNumb = scanner.readLine()
                                                        .toUpperCase();
                                if (parkingOperations.unPark(carNumb)) {
                                     System.out.println("Success");
                                     Log.d("Car unparked ", carNumb);
                                     dataOperationServices
                                                 .writeParkingData(filePath);
                                }
                                break;
                        case statusOfLobby :
                                Log.d("Option", "Display status of lobby");
                                parkingOperations.displayStatusOfLobby();
                                break;
                        case logoutAdmin:
                                Log.d("Option", "Admin Logout");
                                loop = false;
                                dataOperationServices
                                                 .writeParkingData(filePath);
                                break;

                        default: System.out.println("Invalid Entry");
                   }
                } catch (ParkingExceptions e) {
                    System.out.println(e.getMessage());
                }
            } while (loop);

        } else {
            Log.e("Login status", "Wrong details");
            throw new ParkingExceptions("Invalid Credentials....\n\nBye!!");
        }

    }



}
