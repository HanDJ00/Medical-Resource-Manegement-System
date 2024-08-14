package com.ohgiraffers.MedicalResourceManagementSystem.aggregate;

import java.util.Objects;

public class Doctor {

    private int doctor_no;
    private String doctor_name;
    private int doctor_age;
    private char doctor_gender;
    private String doctor_major;
    private String doctor_grade;

    public Doctor() {}

    public Doctor(int doctor_no, String doctor_name, int doctor_age, char doctor_gender, String doctor_major, String doctor_grade) {
        this.doctor_no = doctor_no;
        this.doctor_name = doctor_name;
        this.doctor_age = doctor_age;
        this.doctor_gender = doctor_gender;
        this.doctor_major = doctor_major;
        this.doctor_grade = doctor_grade;
    }

    public int getDoctor_no() {
        return doctor_no;
    }

    public void setDoctor_no(int doctor_no) {
        this.doctor_no = doctor_no;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public int getDoctor_age() {
        return doctor_age;
    }

    public void setDoctor_age(int doctor_age) {
        this.doctor_age = doctor_age;
    }

    public char getDoctor_gender() {
        return doctor_gender;
    }

    public void setDoctor_gender(char doctor_gender) {
        this.doctor_gender = doctor_gender;
    }

    public String getDoctor_major() {
        return doctor_major;
    }

    public void setDoctor_major(String doctor_major) {
        this.doctor_major = doctor_major;
    }

    public String getDoctor_grade() {
        return doctor_grade;
    }

    public void setDoctor_grade(String doctor_grade) {
        this.doctor_grade = doctor_grade;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_no=" + doctor_no +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_age=" + doctor_age +
                ", doctor_gender=" + doctor_gender +
                ", doctor_major='" + doctor_major + '\'' +
                ", doctor_grade='" + doctor_grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctor_no == doctor.doctor_no && doctor_age == doctor.doctor_age && doctor_gender == doctor.doctor_gender && Objects.equals(doctor_name, doctor.doctor_name) && Objects.equals(doctor_major, doctor.doctor_major) && Objects.equals(doctor_grade, doctor.doctor_grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor_no, doctor_name, doctor_age, doctor_gender, doctor_major, doctor_grade);
    }
}
