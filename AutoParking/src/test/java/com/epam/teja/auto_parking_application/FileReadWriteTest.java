package com.epam.teja.auto_parking_application;



import java.io.File;

import com.epam.teja.file_operations.ReadOperations;
import com.epam.teja.file_operations.WriteOperations;

import junit.framework.TestCase;


/**
 * Unit test for Read write operations to files.
 */
public class FileReadWriteTest
    extends TestCase {

    /**
     * WriteOperations Object.
     */
    private WriteOperations writeOperations = new WriteOperations();
    /**
     * ReadOperations object.
     */
    private ReadOperations readOperations = new ReadOperations();
    /**
     * Path of file to test Data.
     */
    static final String FILE_PATH = "src\\test\\testFile.txt";

    /**
     * Test Data.
     */
    static final String DATA = "Test Dataa!";

    /**
     * Read Write Test.
     * @throws Exception IOException.
     */
    public void testAppValidFiles() throws Exception {
        writeOperations.writeData(new File(FILE_PATH).getAbsolutePath(),
                                  DATA,
                                  false);
        assertEquals(DATA, readOperations.readData(new File(FILE_PATH)
                                         .getAbsolutePath())
                                         .split("&&&")[0]);
        writeOperations.writeData(new File(FILE_PATH).getAbsolutePath(),
                                  "",
                                  false);
    }

    /**
     * Read Write Test.
     * @throws Exception IOException.
     */
    public void testAppInvalidFiles() throws Exception {
        boolean thrown = false;
        try {
            readOperations.readData("C:\\test\\details.txt");
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    /**
     * @throws Exception IO EXception.
     */
    public void testWriteData() throws Exception {
        try {
            writeOperations.writeData("C:\\test\\details.txt", DATA, false);
        } catch (Exception e) {

        }
    }
}
