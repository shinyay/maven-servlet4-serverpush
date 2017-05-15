/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.jp.shinyay.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import static javax.servlet.annotation.ServletSecurity.TransportGuarantee.CONFIDENTIAL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.PushBuilder;

/**
 *
 * @author syanagih
 */
@WebServlet(name = "Query", urlPatterns = {"/query"})
@ServletSecurity(httpMethodConstraints = {
    @HttpMethodConstraint(value = "GET", transportGuarantee = CONFIDENTIAL)})
public class Query extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        session.putValue("info", "...");
        PushBuilder pushBuilder = request.newPushBuilder()
                .addHeader("ETag", "3b-60273fc0")
                .setHeader("Content-Type", "text/html;charset=ISO-8859-1")
                .addHeader("headertest", "hello")
                .setHeader("headertest", "hello")
                .addHeader("cookie", "JSESSIONID=" + session.getId())
                .queryString(request.getQueryString())
                .path("query.jsp");
        pushBuilder.push();
        
        response.getWriter().println("<html><head><title>HTTP2 Query Test</title><body>"
                + "<div id=\"query\"></div>"
                + "<script>function loadDoc() { var xhttp = new XMLHttpRequest(); xhttp.onreadystatechange = function() { if (this.readyState == 4 && this.status == 200) { document.getElementById(\"query\").innerHTML = this.responseText; } }; xhttp.open(\"GET\", \"query.jsp?\" + window.location.search, true); xhttp.setRequestHeader(\"headertest\", \"hello\"); xhttp.setRequestHeader(\"If-None-Match\", \"3b-60273fc0\"); xhttp.send(); } loadDoc()</script>"
                + "</body></html>");
    }

}
