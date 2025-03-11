package com.model;

public class EmployeeModel {
    
    private int eid;
    private String ename;
    private String ephone;
    private int esal;

    // Constructor
    public EmployeeModel(int eid, String ename, String ephone, int esal) {
        this.eid = eid;
        this.ename = ename;
        this.ephone = ephone;
        this.esal = esal;
    }

    // Getter and Setter methods
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public int getEsal() {
        return esal;
    }

    public void setEsal(int esal) {
        this.esal = esal;
    }

    // toString method
    @Override
    public String toString() {
        return "EmployeeModel{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", ephone='" + ephone + '\'' +
                ", esal=" + esal +
                '}';
    }
}