package com.model;

public class Dashboard {

    private int totalStudents;
    private int totalCompanies;
    private int totalJobs;
    private int totalApplications;
    private int totalSelected;

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalCompanies() {
        return totalCompanies;
    }

    public void setTotalCompanies(int totalCompanies) {
        this.totalCompanies = totalCompanies;
    }

    public int getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(int totalJobs) {
        this.totalJobs = totalJobs;
    }

    public int getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(int totalApplications) {
        this.totalApplications = totalApplications;
    }

    public int getTotalSelected() {
        return totalSelected;
    }

    public void setTotalSelected(int totalSelected) {
        this.totalSelected = totalSelected;
    }

    public double getPlacementPercentage() {

        if(totalStudents == 0)
            return 0;

        return (totalSelected * 100.0) / totalStudents;
    }

}