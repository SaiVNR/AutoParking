package com.epam.teja.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.ParagraphView;

import com.epam.teja.file_operations.DataOperationServices;
import com.epam.teja.parking_operations.ParkingExceptions;
import com.epam.teja.parking_operations.ParkingOperations;
import com.epam.teja.validators.Validators;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    PrintWriter out = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookies[] = request.getCookies();
        if (null != cookies) {

        } else {
            for (Cookie c : cookies) {
                if (c.getName().equals("loginStatus")) {
                    String status = c.getValue();
                    if (status.equals("false")) {
                        response.sendRedirect("login.jsp");
                    }
                }
            }
        }
        out = response.getWriter();
        response.setContentType("text/html");

        String choice = request.getParameter("choice");
        String carNumber = request.getParameter("carNumber").toUpperCase();
        DataOperationServices dataOperationServices = new DataOperationServices();
        ParkingOperations parkingOperations = null;
        String filePath = "D:\\Teja_Maven\\AutoParkingWeb\\src\\main\\resources\\details.txt";
        int slotsCount = dataOperationServices.getCountOfSlots(filePath);

        if (slotsCount == 0) {
            parkingOperations = ParkingOperations.getInstance(5);
        } else {
            parkingOperations = ParkingOperations.getInstance(slotsCount);
            dataOperationServices.initializeSlots(filePath);
        }
        if (choice.equalsIgnoreCase("park")) {
            Validators validators = new Validators();

            if (validators.validateCarNumber(carNumber)) {
                TreeSet<Integer> freeSlots = ParkingOperations.getFreeSlots();
                if (freeSlots.isEmpty()) {
                    displayAlert("Parking full");
                    request.getRequestDispatcher("home.html").include(request, response);
                } else {
                    try {
                        int allocatedSlot = parkingOperations.park(carNumber);
                        if (allocatedSlot == -1) {
                            displayAlert("Car already in lobby");
                            request.getRequestDispatcher("home.html").include(request, response);
                        } else {
                            displayAlert("Park at slot number: " + allocatedSlot);
                            dataOperationServices.writeParkingData(filePath);
                            request.getRequestDispatcher("home.html").include(request, response);
                        }
                    } catch (Exception e) {
                        out.println(e.getMessage());
                    }

                }
            } else {
                displayAlert("Invalid Car number format");
                request.getRequestDispatcher("home.html").include(request, response);
            }
        } else if (choice.equalsIgnoreCase("unpark")) {
            Validators validators = new Validators();
            if (validators.validateCarNumber(carNumber)) {
                try {
                    if (parkingOperations.unPark(carNumber)) {
                        displayAlert("Unparking Successful");
                        dataOperationServices.writeParkingData(filePath);
                        request.getRequestDispatcher("home.html").include(request, response);
                    } else {
                        displayAlert("Car not found");
                        request.getRequestDispatcher("home.html").include(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                displayAlert("Invalid Car number format");
                request.getRequestDispatcher("home.html").include(request, response);
            }
        } else if (choice.equalsIgnoreCase("Display")) {
            /*
             * DisplayServlet ds = new DisplayServlet(); ds.doPost(request, response);
             */
            response.sendRedirect("display.jsp");
        }
    }

    public void displayAlert(String s) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + s + "');");
        out.println("logout();");
        out.println("</script>");
    }

}
