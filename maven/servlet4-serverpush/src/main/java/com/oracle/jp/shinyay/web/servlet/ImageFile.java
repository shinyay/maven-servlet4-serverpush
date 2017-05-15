package com.oracle.jp.shinyay.web.servlet;

import com.oracle.jp.shinyay.util.Console;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ImageFileDistribution", urlPatterns = {"/imagefile"})
public class ImageFile extends HttpServlet {

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

        String imagePath = request.getServletContext().getRealPath("/WEB-INF/images/");
        String imageName = request.getParameter("name");
        Console.println("IMAGE-PATH:" + imagePath);
        Console.println("IMAGE-NAME:" + imageName);
        
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(imagePath +"/"+ imageName))) {
            ServletOutputStream out = response.getOutputStream();
            
            byte[] data = new byte[1024];
            int len;
            
            while((len = in.read(data, 0, 1024))!=-1){
                out.write(data, 0, len);
            }
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

}
