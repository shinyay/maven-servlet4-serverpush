package com.oracle.jp.shinyay.web.servlet;

import com.oracle.jp.shinyay.util.Console;
import java.io.IOException;
import java.util.Optional;
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
@WebServlet(name = "ServerPush", urlPatterns = {"/index"})
public class ServerPush extends HttpServlet {

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

        PushBuilder pushBuilder = request.newPushBuilder();

        if (pushBuilder != null) {
            pushBuilder
                    .path("bootstrap/css/bootstrap.min.css")
                    .addHeader("content-type", "text/css")
                    .push();
            pushBuilder
                    .path("bootstrap/js/bootstrap.min.js")
                    .addHeader("content-type", "text/javascript")
                    .push();
            pushBuilder
                    .path("images/duke.png")
                    .addHeader("content-type", "image/png")
                    .push();
            pushBuilder
                    .path("images/favicon.jpg")
                    .addHeader("content-type", "image/x-icon")
                    .push();
            pushBuilder
                    .path("images/dog1.jpg")
                    .addHeader("content-type", "image/jpeg")
                    .push();
        }

        Optional.ofNullable(request.getParameter("time"))
                .ifPresent(s -> processBackend(s));
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = request.getRequestDispatcher("index.html");
        disp.forward(request, response);
    }

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
    }

    private void processBackend(String processTime) {
        try {
            Thread.sleep(Integer.parseInt(processTime));
        } catch (InterruptedException ex) {
            Console.println(ex.getMessage());
        }
    }
}
