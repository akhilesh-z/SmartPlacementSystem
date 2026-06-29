package com.model;



public class Job {

    private int jobId;
    private int companyId;
    private String title;
    private String description;
    private double minCgpa;
    private double salary;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description) {
        this.description = description;
    }

    public double getMinCgpa() {
        return minCgpa;
    }

    public void setMinCgpa(
            double minCgpa) {
        this.minCgpa = minCgpa;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(
            double salary) {
        this.salary = salary;
    }
}