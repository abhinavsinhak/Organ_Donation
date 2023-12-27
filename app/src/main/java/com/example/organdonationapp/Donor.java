// File: Donor.java
package com.example.organdonationapp;

import java.io.Serializable;

public class Donor implements Serializable {
    private String name;
    private String organ;
    private String aadhar;
    private String mobile;
    private String gender;
    private int age;

    public Donor(String name, String organ, String aadhar, String mobile, String gender, int age) {
        this.name = name;
        this.organ = organ;
        this.aadhar = aadhar;
        this.mobile = mobile;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getOrgan() {
        return organ;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getMobile() {
        return mobile;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}