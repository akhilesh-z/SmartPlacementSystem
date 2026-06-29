package com.model;

public class Company {

    private int companyId;
    private String companyName;
    private String email;
    private String password;
    private double minCgpa;

    public Company() {}

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMinCgpa() {
        return minCgpa;
    }

    public void setMinCgpa(double minCgpa) {
        this.minCgpa = minCgpa;
    }
}