package com.oracle.jp.shinyay.web.servlet;

import com.oracle.jp.shinyay.util.Console;
import java.io.IOException;
import java.util.Optional;
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
@WebServlet(name = "Http2Forward", urlPatterns = {"/http2"})
public class Http2Forward extends HttpServlet {

    private final String[] PUSH_JS = {
        "js/libs/jquery/2.0.2/jquery.min.js",
        "js/libs/least/least.min.js"
    };

    private final String[] PUSH_IMAGES = {
        "images/s-dog1.jpg",
        "images/s-dog2.jpg",
        "images/s-dog3.jpg",
        "images/s-dog4.jpg",
        "images/s-dog5.jpg",
        "images/s-dog6.jpg",
        "images/s-dog7.jpg",
        "images/s-dog8.jpg",
        "images/s-dog9.jpg",
        "images/s-dog10.jpg",
        "images/s-dog11.jpg",
        "images/s-dog12.jpg",
        "images/s-dog13.jpg",
        "images/s-dog14.jpg",
        "images/s-dog15.jpg",
        "images/s-dog16.jpg",
        "images/s-dog17.jpg",
        "images/s-dog18.jpg",
        "images/s-dog19.jpg",
        "images/s-dog20.jpg"
    };

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
            pushCSS(pushBuilder, "css/least.min.css");
            Stream.of(PUSH_JS).forEach(s -> pushJS(pushBuilder, s));
            Stream.of(PUSH_IMAGES).forEach(s -> pushJPEG(pushBuilder, s));
        }
        
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

    private void processBackend(String processTime) {
        try {
            Thread.sleep(Integer.parseInt(processTime));
        } catch (InterruptedException ex) {
            Console.println(ex.getMessage());
        }
    }
}
