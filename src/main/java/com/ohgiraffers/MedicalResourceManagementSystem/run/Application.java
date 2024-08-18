package com.ohgiraffers.MedicalResourceManagementSystem.run;

import com.ohgiraffers.MedicalResourceManagementSystem.aggregate.Patient;
import com.ohgiraffers.MedicalResourceManagementSystem.service.UserService;

import java.util.Scanner;

public class Application {

    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("===== 의료 자원 관리 시스템 =====");
            System.out.println("1. 모든 환자 정보 보기");
            System.out.println("2. 환자 찾기");
            System.out.println("3. 환자 추가");
            System.out.println("4. 환자 정보 수정");
            System.out.println("5. 모든 의사 정보 보기");
            System.out.println("6. 의사 찾기");
            System.out.println("7. 의사 추가");
            System.out.println("8. 의사 정보 수정");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택 :");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: userService.findAllPatients(); break;
                case 2: userService.findPatientByNo(chooseNo()); break;
                case 3: userService.addPatient(patientnewadd()); break;
                case 4: break;
                case 5: userService.findAllDoctors(); break;
                case 6: userService.findAllDoctorByNo(chooseNo());
                case 7: break;
                case 8: break;
                case 9:
                    System.out.println("의료 자원 관리 시스템을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘 못 입력했습니다.");
            }
        }
    }

    private static int chooseNo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("회원 번호 입력 : ");
        return scanner.nextInt();
    }

    private static Patient patientnewadd() {
        Patient newPatient = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String patient_name = sc.nextLine();

        System.out.print("나이를 입력하세요: ");
        int patient_age = sc.nextInt();

        System.out.print("성별를 입력하세요: ");
        char patient_gender = sc.next().charAt(0);

        System.out.print("주치의 번호를 입력하세요: ");
        int doctor_no = sc.nextInt();

        System.out.print("진단명을 입력하세요: ");
        String patient_diagnostic = sc.nextLine();

        System.out.print("병실 번호를 입력하세요: ");
        int patient_hospital_bed = sc.nextInt();

        System.out.print("수납여부를 입력하세요: ");
        char expenses_received = sc.next().charAt(0);


        /* 회원으로부터 회원가입을 위한 정보를 입력받아 Member 타입 객체 하나로 가공 처리할 방법이 두 가지가 있다.
         *  1. 생성자 방식(장: 한줄 코딩, 단: 따로 생성자 추가 및 생성자의 매개변수가 다소 늘어날 수 있음(리펙토링 징조)
         *  2. setter 방식(장: 초기화 할 갯수 수정 용이, 가독성이 좋음, 단: 코드의 줄 수가 늘어남)
         * */
        newPatient = new Patient(patient_name,patient_age,patient_gender,doctor_no,patient_diagnostic,patient_hospital_bed,expenses_received);


        return newPatient;
    }
}
