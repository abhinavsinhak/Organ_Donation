// File: Receiver.java
package com.example.organdonationapp;

import java.io.Serializable;

public class Receiver implements Serializable {
    private String name;
    private String organNeeded;
    private String aadhar;
    private String mobile;
    private String gender;
    private int age;

    public Receiver(String name, String organNeeded, String aadhar, String mobile, String gender, int age) {
        this.name = name;
        this.organNeeded = organNeeded;
        this.aadhar = aadhar;
        this.mobile = mobile;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getOrganNeeded() {
        return organNeeded;
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