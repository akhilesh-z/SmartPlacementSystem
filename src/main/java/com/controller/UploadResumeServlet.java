package com.controller;

import java.io.File;
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

       
      
        String uploadPath = System.getenv("UPLOAD_PATH");

        if (uploadPath == null || uploadPath.isBlank()) {

            uploadPath = "C:/PlacementUploads";

        }
                
        System.out.println(uploadPath);
        String originalName = part.getSubmittedFileName();

        String extension = originalName.substring(originalName.lastIndexOf("."));

        String fileName = student.getStudentId()
                + "_"
                + System.currentTimeMillis()
                + extension;

        File file = new File(uploadPath, fileName);

        part.write(file.getAbsolutePath());

        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        File uploadDir=new File(uploadPath);

        if(!uploadDir.exists()){

        	uploadDir.mkdirs();

        }
        
        System.out.println(fileName);
        Cloudinary cloudinary = CloudinaryUtil.getInstance();

        Map uploadResult = cloudinary.uploader().upload(
                part.getInputStream(),
                ObjectUtils.emptyMap());

        String resumeUrl = uploadResult.get("secure_url").toString();
        System.out.println("Saved File: " + fileName);

        UserDAO dao=new UserDAO();

        dao.updateResume(student.getStudentId(), resumeUrl);

        response.sendRedirect("profile?upload=success");

    }

}