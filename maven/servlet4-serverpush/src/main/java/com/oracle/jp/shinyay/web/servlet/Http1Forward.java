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

/**
 *
 * @author syanagih
 */
@WebServlet(name = "Http1Forward", urlPatterns = {"/http1"})
public class Http1Forward extends HttpServlet {

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
                Optional.ofNullable(request.getParameter("time"))
                .ifPresent(s -> processBackend(s));
        RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/gallery.jsp");
        disp.forward(request, response);
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
        RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/gallery.jsp");
        disp.forward(request, response);
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

        private void processBackend(String processTime) {
        try {
            Thread.sleep(Integer.parseInt(processTime));
        } catch (InterruptedException ex) {
            Console.println(ex.getMessage());
        }
    }
}
