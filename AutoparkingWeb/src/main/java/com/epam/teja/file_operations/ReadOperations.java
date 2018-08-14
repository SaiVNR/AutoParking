package com.epam.teja.file_operations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Saiteja_Suggula
 *
 */
public class ReadOperations {
    /**
     * Constructor.
     */
    public ReadOperations() {

    }
    /**
     * @param fileName fileName to read Data
     * @throws IOException If unable to fetch file.
     * @return Read data.
     */
    public String readData(final String fileName) throws IOException {
        String data = "";
        BufferedReader bufferedWriter
                      = new BufferedReader(new FileReader(fileName));
            String sCurrentLine = "";
            while ((sCurrentLine = bufferedWriter.readLine()) != null) {
                data += sCurrentLine + "&&&";
            }
        bufferedWriter.close();
        return data;
    }
}
