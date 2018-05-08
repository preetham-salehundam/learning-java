package com.company.Serialization;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 42L;

    private int employeeId;
    private String employeeName;
    private String departmentName;
    //statics will not be searlized as they dont belong to the object
    public static int phoneNumber;
    //transients wont be stored
    transient int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", id=" + id +
                '}';
    }
}
