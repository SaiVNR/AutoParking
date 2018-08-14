package com.epam.teja.auto_parking_application;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.epam.teja.file_operations.DataOperationServices;

import junit.framework.TestCase;

/**
 * @author Saiteja_Suggula
 *
 */
public class MainTest extends TestCase {
    /**
     * @throws Exception Various types.
     */
    public void testMain() throws Exception {

        App.setFilePath("src\\test\\testData.txt");
        new DataOperationServices().resetData("src\\test\\" + "testData.txt");
        StringBuilder input = new StringBuilder();
        InputStream inputStream;
        input.append("3\n");
        input.append("1\n");
        input.append("ts07eu8639\n");
        input.append("1\n");
        input.append("ts07eu7639\n");
        input.append("2\n");
        input.append("ts07eu8639\n");
        input.append("7\n");
        input.append("3\n");
        input.append("2\n");
        input.append("ts07eu8639\n");
        input.append("4\n");

        inputStream = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        App.main(new String[] {"admin", "admin"});
    }

    /**
     * @throws Exception Various types.
     */
    public void testDataPresent() throws Exception {

        App.setFilePath("src\\test\\testData.txt");
        StringBuilder input = new StringBuilder();
        InputStream inputStream;

        input.append("1\n");
        input.append("ts07eu8639\n");
        input.append("1\n");
        input.append("ts07eu7639\n");
        input.append("2\n");
        input.append("ts07eu8639\n");
        input.append("7\n");
        input.append("3\n");
        input.append("2\n");
        input.append("ts07eu8639\n");
        input.append("4\n");

        inputStream = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        App.main(new String[] {"admin", "admin"});

    }

}
