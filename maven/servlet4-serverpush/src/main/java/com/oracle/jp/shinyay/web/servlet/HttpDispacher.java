package com.oracle.jp.shinyay.web.servlet;

import com.oracle.jp.shinyay.util.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author syanagih
 */
@WebServlet(name = "Http1Dispacher", urlPatterns = {"/dispatch"})
public class HttpDispacher extends HttpServlet {

    private final String HTTP_TYPE = "httptype";
    private final String TARGET_HTTP1 = "http1";
    private final String TARGET_HTTP2 = "http2";
    private final String TARGET_INCLUDE = "include";

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

        String target = request.getParameter(HTTP_TYPE);
        Console.println("TARGET: " + target);

        if (target.equals(TARGET_HTTP1)) {
            request.getRequestDispatcher("/" + TARGET_HTTP1).forward(request, response);
        } else if (target.equals(TARGET_HTTP2)) {
            request.getRequestDispatcher("/" + TARGET_HTTP2).forward(request, response);
        } else if (target.equals(TARGET_INCLUDE)) {
            request.getRequestDispatcher("/" + TARGET_INCLUDE).forward(request, response);
        }
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
        doGet(request, response);
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
