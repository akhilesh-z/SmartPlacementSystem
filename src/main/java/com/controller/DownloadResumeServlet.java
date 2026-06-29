package com.controller;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/downloadResume")
public class DownloadResumeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("file");

        if(fileName == null || fileName.isEmpty()){

            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;

        }

        String uploadPath = getServletContext().getRealPath("/uploads");

        File file = new File(uploadPath, fileName);

        if(!file.exists()){

            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;

        }

        response.setContentType(getServletContext().getMimeType(file.getName()));

        response.setContentLength((int) file.length());

        response.setHeader("Content-Disposition",
                "inline; filename=\"" + file.getName() + "\"");

        FileInputStream fis = new FileInputStream(file);

        OutputStream os = response.getOutputStream();

        byte[] buffer = new byte[4096];

        int bytesRead;

        while((bytesRead = fis.read(buffer)) != -1){

            os.write(buffer,0,bytesRead);

        }

        fis.close();
        os.flush();
        os.close();

    }

}