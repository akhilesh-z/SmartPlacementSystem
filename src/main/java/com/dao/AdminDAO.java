package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Admin;
import com.model.Student;
import com.util.DBConnection;

public class AdminDAO {

    public Admin login(String username,String password){

        Admin admin=null;

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(

            "SELECT * FROM admin WHERE username=? AND password=?");

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                admin=new Admin();

                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return admin;

    }
   

}