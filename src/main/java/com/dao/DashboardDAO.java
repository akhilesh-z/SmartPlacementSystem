package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Dashboard;
import com.util.DBConnection;

public class DashboardDAO {

    public Dashboard getStatistics() {

        Dashboard d = new Dashboard();

        try(Connection con = DBConnection.getConnection()) {

            d.setTotalStudents(getCount(con,"students"));
            d.setTotalCompanies(getCount(con,"companies"));
            d.setTotalJobs(getCount(con,"jobs"));
            d.setTotalApplications(getCount(con,"applications"));

            PreparedStatement ps = con.prepareStatement(
                    "SELECT COUNT(*) FROM applications WHERE status='Selected'");

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                d.setTotalSelected(rs.getInt(1));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return d;

    }

    private int getCount(Connection con,String table) throws Exception {

        PreparedStatement ps =
                con.prepareStatement("SELECT COUNT(*) FROM " + table);

        ResultSet rs = ps.executeQuery();

        if(rs.next())
            return rs.getInt(1);

        return 0;
    }

}