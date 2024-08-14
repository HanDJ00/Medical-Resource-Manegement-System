package com.ohgiraffers.MedicalResourceManagementSystem.repositorty;

import com.ohgiraffers.MedicalResourceManagementSystem.aggregate.Patient;

import java.io.*;
import java.util.ArrayList;

public class PatientRepository {
    private final ArrayList<Patient> patientsList = new ArrayList<>();
    private static final String PATIENT_FILE_PATH = "src/main/java/com/MedicalResourceManagementSystem/aggregate/db/patientDB.dat";

    public PatientRepository() {

        File file = new File(PATIENT_FILE_PATH);

        if (file.exists()) {
            ArrayList<Patient> patients = new ArrayList<>();
            patients.add(new Patient(1, "김길남", 57, 'M', 1, "퇴행성 관절염", 712, 'N'));
            patients.add(new Patient(2, "박옥순", 30, 'Y', 1, "류마티스 관절염", 702, 'N'));
            patients.add(new Patient(3, "이안나", 82, 'Y', 1, "각기병", 502, 'Y'));
            patients.add(new Patient(4, "최병남", 15, 'M', 1, "광직성 척추염", 713, 'N'));
            patients.add(new Patient(5, "정재완", 26, 'M', 1, "건초염", 614, 'N'));
            patients.add(new Patient(6, "나완중", 33, 'M', 2, "독감", 801, 'Y'));
            patients.add(new Patient(7, "아무개", 25, 'M', 2, "결핵", 803, 'Y'));
            patients.add(new Patient(8, "채지찬", 75, 'M', 2, "당뇨", 910, 'N'));
            patients.add(new Patient(9, "박병남", 42, 'M', 2, "신부전", 203, 'Y'));
            patients.add(new Patient(10, "연아연", 43, 'Y', 1, "미세골절", 803, 'N'));
            patients.add(new Patient(11, "신수빈", 12, 'Y', 3, "심근경색", 301, 'N'));
            patients.add(new Patient(12, "한재영", 21, 'M', 4, "뇌졸중", 302, 'N'));
            patients.add(new Patient(12, "김민준", 27, 'M', 4, "뇌진탕", 1101, 'Y'));
            patients.add(new Patient(12, "이서윤", 31, 'Y', 2, "간암", 1102, 'Y'));
            patients.add(new Patient(12, "최유진", 37, 'Y', 1, "골절", 1103, 'Y'));
            patients.add(new Patient(12, "강다현", 22, 'Y', 5, "맹장", 1104, 'Y'));
            patients.add(new Patient(12, "임나은", 17, 'Y', 2, "가벼운 감기", 1105, 'Y'));


            savePatients(file, patients);
        }

        loadPatients(file);
    }

    private void loadPatients(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            while(true) {
                patientsList.add((Patient) ois.readObject());
            }



        } catch(EOFException e) {
            System.out.println("회원 정보를 모두 로딩하였습니다.");
        }

        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void savePatients(File file, ArrayList<Patient> patients) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                patientsList.add((Patient) ois.readObject());
            }

        } catch (EOFException e) {
            System.out.println("환자 정보를 모두 로딩하였습니다.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
