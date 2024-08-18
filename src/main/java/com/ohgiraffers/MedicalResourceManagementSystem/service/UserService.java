package com.ohgiraffers.MedicalResourceManagementSystem.service;

import com.ohgiraffers.MedicalResourceManagementSystem.aggregate.Doctor;
import com.ohgiraffers.MedicalResourceManagementSystem.aggregate.Patient;
import com.ohgiraffers.MedicalResourceManagementSystem.repositorty.DoctorRepository;
import com.ohgiraffers.MedicalResourceManagementSystem.repositorty.PatientRepository;

import java.util.ArrayList;

public class UserService {

    private final DoctorRepository doctorRepository = new DoctorRepository();

    private final PatientRepository patientRepository = new PatientRepository();


    public void findAllPatients() {
        ArrayList<Patient> findUsers = patientRepository.selectAllUsers();

        for (Patient patient : findUsers) {
            System.out.println("patient = " + patient);
        }
    }


    public void findAllDoctors() {
        ArrayList<Doctor> findUsers = doctorRepository.selectAllUsers();

        for (Doctor doctor : findUsers) {
            System.out.println("doctor = " + doctor);
        }
    }

    public void findPatientByNo(int no) {
        Patient selectedPatient = patientRepository.selectUserByNo(no);

        if (selectedPatient != null) {
            System.out.println(selectedPatient);
        } else {
            System.out.println("해당 번호를 가진 환자는 없습니다.");
        }
    }

    public void findAllDoctorByNo(int no) {
        Doctor selectedDoctor = doctorRepository.selectUserByNo(no);

        if (selectedDoctor != null) {
            System.out.println(selectedDoctor);
        } else {
            System.out.println("해당 번호를 가진 환자는 없습니다.");
        }
    }

    public void addPatient(Patient patientnewadd) {
        int lastMemberNo = patientRepository.selectLastPatientNo();
        patientnewadd.setPatient_no(lastMemberNo + 1);

        int result = patientRepository.insertPatient(patientnewadd);

        if (result == 1) {
            System.out.println(patientnewadd.getPatient_no() + "님 회원 가입이 완료 되었습니다.");
            /* DMBS와의 연동을 할 경우 commit, rollback 등의 처리 */
        }
    }
}
