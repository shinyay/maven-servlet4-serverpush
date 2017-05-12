package com.oracle.jp.shinyay.web.servlet;

import com.oracle.jp.shinyay.util.Console;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

/**
 *
 * @author syanagih
 */
@WebServlet(name = "ServerPushInfo", urlPatterns = {"/info"})
public class ServerPushInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Console.println("[HTTP-REQUEST]==========");
        Collections.list(request.getHeaderNames())
                .stream()
                .forEach(s -> Console.println(s + " : " + request.getHeader(s)));
        Console.println("===================");

        PushBuilder pushBuilder = request.newPushBuilder();

        if (pushBuilder != null) {
            Console.println("[PUSH-BUILDER]==========");
            pushBuilder.getHeaderNames()
                    .stream()
                    .forEach(s -> Console.println(s + " : " + pushBuilder.getHeader(s)));
            Console.println("===================");
        }

        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = request.getRequestDispatcher("index.html");
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
