package com.ohgiraffers.MedicalResourceManagementSystem.repositorty;

import com.ohgiraffers.MedicalResourceManagementSystem.aggregate.Doctor;
import com.ohgiraffers.MedicalResourceManagementSystem.aggregate.Patient;

import java.io.*;
import java.util.ArrayList;


public class DoctorRepository {

    private final ArrayList<Doctor> doctorsList = new ArrayList<>();
    private static final String DOCTOR_FILE_PATH = "src/main/java/com/ohgiraffers/MedicalResourceManagementSystem/db/doctorDB.dat";

    public DoctorRepository() {

        File file = new File(DOCTOR_FILE_PATH);

        if (!file.exists()) {
            ArrayList <Doctor> doctors = new ArrayList<>();
            doctors.add(new Doctor(1,"장두팔",45,'M',"정형외과","교수"));
            doctors.add(new Doctor(2,"이미나",26,'W',"내과","인턴 1년차"));
            doctors.add(new Doctor(3,"김강철",28,'M',"심장외과","레지던트 2년차"));
            doctors.add(new Doctor(4,"박길남",34,'M',"신경외과","펠로우 2년차"));
            doctors.add(new Doctor(5,"이국종",52,'M',"일반외과","교수"));


            saveDoctors(file, doctors);
        }

        loadDoctors(file);
    }

    private void loadDoctors(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            while(true) {
                doctorsList.add((Doctor) ois.readObject());
            }



        } catch(EOFException e) {
            System.out.println("회원 정보를 모두 로딩하였습니다.");
        }

        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }


    private void saveDoctors(File file, ArrayList<Doctor> doctors) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            for (Doctor doctor : doctors) {
                oos.writeObject(doctor);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Doctor> selectAllUsers() {
        return doctorsList;
    }

    public Doctor selectUserByNo(int no) {
        for (Doctor doctor : doctorsList) {
            if(doctor.getDoctor_no() == no) {
                return doctor;
            }
        }
        return null;
    }
}
