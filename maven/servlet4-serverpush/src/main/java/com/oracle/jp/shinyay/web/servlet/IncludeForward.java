package com.oracle.jp.shinyay.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
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
@WebServlet(name = "Include", urlPatterns = {"/include"})
public class IncludeForward extends HttpServlet {

    private final String[] PUSH_JS = {
        "bootstrap/js/bootstrap.min.js"
    };

    private final String[] PUSH_CSS = {
        "bootstrap/css/bootstrap.min.css"
    };

    private final String[] PUSH_HTML = {
        "fragment.html"
    };

    private final String[] PUSH_IMAGES = {};

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
        PushBuilder pushBuilder = request.newPushBuilder();
        if (pushBuilder != null) {
            Stream.of(PUSH_JS).forEach(s -> pushJS(pushBuilder, s));
            Stream.of(PUSH_CSS).forEach(s -> pushCSS(pushBuilder, s));
            Stream.of(PUSH_HTML).forEach(s -> pushHTML(pushBuilder, s));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(IncludeForward.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher disp = request.getRequestDispatcher("include.jsp");
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
    }

    private void pushJPEG(PushBuilder pushBuilder, String path) {
        pushBuilder
                .path(path)
                .addHeader("content-type", "image/jpeg")
                .push();
    }

    private void pushJS(PushBuilder pushBuilder, String path) {
        pushBuilder
                .path(path)
                .addHeader("content-type", "text/javascript")
                .push();
    }

    private void pushCSS(PushBuilder pushBuilder, String path) {
        pushBuilder
                .path(path)
                .addHeader("content-type", "text/css")
                .push();
    }

    private void pushHTML(PushBuilder pushBuilder, String path) {
        pushBuilder
                .path(path)
                .addHeader("content-type", "text/html")
                .push();
    }
}
