package com.controller;


import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dao.UserDAO;
import com.model.Student;
import com.util.CloudinaryUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/uploadResume")
@MultipartConfig(
fileSizeThreshold = 1024*1024,
maxFileSize = 1024*1024*5,
maxRequestSize = 1024*1024*10
)

public class UploadResumeServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        HttpSession session=request.getSession();

        Student student=(Student)session.getAttribute("student");

        Part part=request.getPart("resume");

       
      
        String originalName = part.getSubmittedFileName();

        String extension = originalName.substring(originalName.lastIndexOf("."));

        String fileName = student.getStudentId()
                + "_"
                + System.currentTimeMillis()
                + extension;

        Cloudinary cloudinary = CloudinaryUtil.getInstance();

        Map uploadResult = cloudinary.uploader().upload(
                part.getInputStream(),
                ObjectUtils.asMap(
                        "public_id", fileName,
                        "resource_type", "raw"
                ));

        String resumeUrl = uploadResult.get("secure_url").toString();

        UserDAO dao = new UserDAO();

        dao.updateResume(student.getStudentId(), resumeUrl);

        response.sendRedirect("profile?upload=success");
        

    }

}