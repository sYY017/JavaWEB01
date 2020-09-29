package com.tjetc.domain;

public class Emp {
    private int id;
    private int postType;
    private String empName;
    private int empSex;
    private int empAge;
    private String empDepart;
    private int empYear;

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", postType=" + postType +
                ", empName='" + empName + '\'' +
                ", empSex=" + empSex +
                ", empAge=" + empAge +
                ", empDepart='" + empDepart + '\'' +
                ", empYear=" + empYear +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpSex() {
        return empSex;
    }

    public void setEmpSex(int empSex) {
        this.empSex = empSex;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpDepart() {
        return empDepart;
    }

    public void setEmpDepart(String empDepart) {
        this.empDepart = empDepart;
    }

    public int getEmpYear() {
        return empYear;
    }

    public void setEmpYear(int empYear) {
        this.empYear = empYear;
    }
}
