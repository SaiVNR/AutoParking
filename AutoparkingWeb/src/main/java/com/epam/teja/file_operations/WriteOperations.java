package com.epam.teja.file_operations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Saiteja_Suggula
 *
 */
public class WriteOperations {

    /**
     * Constructor.
     */
    public WriteOperations() {

    }

    /**
     * @param fileName fileName to Write Data.
     * @param content  Content to be written.
     * @param shouldAppend should the data to be appended or replaced.
     * @throws Exception IO Exception
     */
    public void writeData(final String fileName, final String content,
                                 final boolean shouldAppend) throws Exception {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, shouldAppend);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
        } catch (IOException e) {

        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (fileWriter != null) {
                fileWriter.close();
            }

        }
    }
}
