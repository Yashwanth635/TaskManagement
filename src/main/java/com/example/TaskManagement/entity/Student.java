package com.example.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @NotBlank
    private String fName;
    @NotBlank
    private String lName;
    @NotBlank
    private int standard;
    @NotBlank
    private long phoneNo;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", standard=" + standard +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
