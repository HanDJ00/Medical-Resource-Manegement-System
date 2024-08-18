package com.ohgiraffers.MedicalResourceManagementSystem.aggregate;

import java.io.Serializable;
import java.util.Objects;

public class Patient implements Serializable {

    private int patient_no;
    private String patient_name;
    private int patient_age;
    private char patient_gender;
    private int doctor_no;
    private String patient_diagnostic;
    private int patient_hospital_bed;
    private char expenses_received;

    public Patient(String patient_name, int patient_age, char patient_gender, int doctor_no, String patient_diagnostic, int patient_hospital_bed, char expenses_received) {}

    public Patient(int patient_no, String patient_name, int patient_age, char patient_gender, int doctor_no, String patient_diagnostic, int patient_hospital_bed, char expenses_received) {
        this.patient_no = patient_no;
        this.patient_name = patient_name;
        this.patient_age = patient_age;
        this.patient_gender = patient_gender;
        this.doctor_no = doctor_no;
        this.patient_diagnostic = patient_diagnostic;
        this.patient_hospital_bed = patient_hospital_bed;
        this.expenses_received = expenses_received;
    }

    public int getPatient_no() {
        return patient_no;
    }

    public void setPatient_no(int patient_no) {
        this.patient_no = patient_no;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public char getPatient_gender() {
        return patient_gender;
    }

    public void setPatient_gender(char patient_gender) {
        this.patient_gender = patient_gender;
    }

    public int getDoctor_no() {
        return doctor_no;
    }

    public void setDoctor_no(int doctor_no) {
        this.doctor_no = doctor_no;
    }

    public String getPatient_diagnostic() {
        return patient_diagnostic;
    }

    public void setPatient_diagnostic(String patient_diagnostic) {
        this.patient_diagnostic = patient_diagnostic;
    }

    public int getPatient_hospital_bed() {
        return patient_hospital_bed;
    }

    public void setPatient_hospital_bed(int patient_hospital_bed) {
        this.patient_hospital_bed = patient_hospital_bed;
    }

    public char getExpenses_received() {
        return expenses_received;
    }

    public void setExpenses_received(char expenses_received) {
        this.expenses_received = expenses_received;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_no=" + patient_no +
                ", patient_name='" + patient_name + '\'' +
                ", patient_age=" + patient_age +
                ", patient_gender=" + patient_gender +
                ", doctor_no=" + doctor_no +
                ", patient_diagnostic='" + patient_diagnostic + '\'' +
                ", patient_hospital_bed=" + patient_hospital_bed +
                ", expenses_received=" + expenses_received +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patient_no == patient.patient_no && patient_age == patient.patient_age && patient_gender == patient.patient_gender && doctor_no == patient.doctor_no && patient_hospital_bed == patient.patient_hospital_bed && expenses_received == patient.expenses_received && Objects.equals(patient_name, patient.patient_name) && Objects.equals(patient_diagnostic, patient.patient_diagnostic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient_no, patient_name, patient_age, patient_gender, doctor_no, patient_diagnostic, patient_hospital_bed, expenses_received);
    }
}
