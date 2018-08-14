package com.epam.teja.file_operations;

import java.util.Date;

/**
 * @author Saiteja_Suggula.
 *
 */
public final class Log {

    /**
     * Object to perform Write Operations.
     */
    private static WriteOperations writeOperations = new WriteOperations();
    /**
     * Specifies type of Log statement.
     */
    private static String type = "Verbose";

    /**
     * Log file path.
     */
    private static final String LOG_FILE_PATH = "D:\\Teja_Maven\\AutoParkingWeb\\src\\main\\resources\\Log.txt";

    /**
     * Constructor.
     */
    private Log() {
    }

    /**
     * @param tag     Tag
     * @param message Message
     */
    public static void e(final String tag, final String message) {
        type = "Error";
        writeDataToLog(tag, message);

    }

    /**
     * @param tag     Tag
     * @param message Message
     */
    public static void v(final String tag, final String message) {
        type = "Verbose";
        writeDataToLog(tag, message);
    }

    /**
     * @param tag     Tag
     * @param message Message
     */
    public static void d(final String tag, final String message) {
        type = "Debug";
        writeDataToLog(tag, message);
    }

    /**
     * @param tag Tag
     * @param message Message
     */
    private static void writeDataToLog(final String tag, final String message) {
        try {
            String content = "[" + type + "]";
            content += " [" + new Date() + "]";
            content += " " + tag + ": ";
            content += message + System.lineSeparator();
            writeOperations.writeData(LOG_FILE_PATH, content, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
