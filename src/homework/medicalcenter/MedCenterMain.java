package homework.medicalcenter;

import homework.medicalcenter.model.Doctor;
import homework.medicalcenter.model.Patient;
import homework.medicalcenter.storage.DoctorStorage;
import homework.medicalcenter.storage.PatientStorage;

import java.util.Date;
import java.util.Scanner;

public class MedCenterMain {

    private static Scanner scanner = new Scanner(System.in);
    private static DoctorStorage doctorStorage = new DoctorStorage();
    private static PatientStorage patientStorage = new PatientStorage();

    public static void main(String[] args) {

        // list of ready doctors and patients for test
        // Doctors id starts with 'D'
        // Patients id starts with 'P'
        Doctor doctor1 = new Doctor("D001", "Poxos", "Poxosyan", "+37499112233", "poxospoxosyan@gmail.com", "Anesthesiologist");
        Doctor doctor2 = new Doctor("D002", "Petros", "Petrosyan", "+37499332211", "petrospetrosyan@gmail.com", "Cardiologist");
        Doctor doctor3 = new Doctor("D003", "Martiros", "Martirosyan", "+37499221133", "martirosmartirosyan@gmail.com", "Nurse");
        Doctor doctor4 = new Doctor("D004", "Mamikon", "Mamikonyan", "+37443113487", "mamikonmamikonyan@gmail.com", "Orthodontist");
        Patient patient1 = new Patient("John", "Wick", "(818)5607865", "P001", doctor1, "22/05/2023 11:00");
        Patient patient2 = new Patient("Mike", "Wazovski", "(818)1234567", "P002", doctor2, "22/05/2023 15:00");
        Patient patient3 = new Patient("Bob", "Hamilton", "(818)7654321", "P003", doctor3, "10/10/2023 14:00");
        Patient patient4 = new Patient("Jack", "Sparrow", "(818)0987654", "P004", doctor1, "22/05/2023 10:00");
        patientStorage.add(patient1);
        patientStorage.add(patient2);
        patientStorage.add(patient3);
        patientStorage.add(patient4);
        doctorStorage.add(doctor1);
        doctorStorage.add(doctor2);
        doctorStorage.add(doctor3);
        doctorStorage.add(doctor4);

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addDoctor();
                    break;
                case "2":
                    searchDoctorByProfession();
                    break;
                case "3":
                    deleteDoctorById();
                    break;
                case "4":
                    changeDoctorById();
                    break;
                case "5":
                    addPatient();
                    break;
                case "6":
                    printAllPatientsByDoctor();
                    break;
                case "7":
                    printAllPatients();
                    break;
                case "8":
                    printAllDoctors();
                    break;
                case "9":
                    deletePatientById();
                    break;
                default:
                    System.out.println("Invalid command. Try again!\n");
            }
        }
    }

    private static void deletePatientById() {
        System.out.println("Please choose one of the patients from the list and enter patient's id");// <- next 7 lines is for checking if we have any patient with requested id
        patientStorage.print();
        String patientId = scanner.nextLine();
        Patient patientFromStorage = patientStorage.getById(patientId);
        if (patientFromStorage == null) {
            System.out.println("Patient with \'" + patientId + "\" does not exists!!!");
            return;
        }
        patientStorage.deleteById(patientId);
    }

    private static void printAllPatientsByDoctor() {
        System.out.println("Please enter doctor's id from the list bellow"); // <- next 7 lines is for checking if we have a doctor with requested id
        doctorStorage.print();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with \'" + doctorId + "\" id does not exists!!!");
            return;
        }
        Patient[] patientsByDoctorId = patientStorage.getPatientsByDoctorId(doctorId);
        int countOfMatches = 0;
        if (patientsByDoctorId != null) { // checking if we have at least 1 patient with given doctor id
            for (int i = 0; i < patientsByDoctorId.length; i++) {
                if (patientsByDoctorId[i].getDoctor().getId().equals(doctorId)) {
                    System.out.println(patientsByDoctorId[i]);
                    countOfMatches++;
                }
            }
            System.out.println();
        }
        if (countOfMatches == 0) {
            System.out.println("No matches found!\n");
        }
    }

    private static void addPatient() {
        System.out.println("Please enter patient's id");// <- next 6 lines is for checking if we already have a patient with requested id
        String patientId = scanner.nextLine();
        Patient patientFromStorage = patientStorage.getById(patientId);
        if (patientFromStorage != null) {
            System.out.println("Patient with \'" + patientId + "\" id already exists!!!");
            return;
        }
        System.out.println("Please enter patient's name");
        String patientName = scanner.nextLine();
        System.out.println("Please enter patient's surname");
        String patientSurname = scanner.nextLine();
        System.out.println("Please enter patient's phone");
        String patientPhone = scanner.nextLine();
        System.out.println("Please choose patient doctor by doctor id");// <- next 7 lines is for checking if we have a doctor with requested id
        doctorStorage.print();
        String chosenDoctorForPatient = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(chosenDoctorForPatient);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with \'" + chosenDoctorForPatient + "\" id does not exists!!!");
            return;
        }
        Doctor chosenDoctor = doctorStorage.getById(chosenDoctorForPatient); // getting doctor id to attach him/her to the patient file
        Date currentDate = new Date();
        String dateTimeNow = String.valueOf(currentDate); // recording date and time patient was registered
        Patient patient = new Patient(patientId, patientName, patientSurname, patientPhone, chosenDoctor, dateTimeNow);
        patientStorage.add(patient);
        System.out.println(patient);
        System.out.println("Patient is registered!\n");
    }

    private static void printAllPatients() {
        patientStorage.print();
        System.out.println();
    }

    private static void changeDoctorById() {
        System.out.println("Please choose one of the doctors from the list and enter doctor id"); // <- next 7 lines is for checking if we have a doctor with requested id
        doctorStorage.print();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with \'" + doctorId + "\" id does not exists!!!");
            return;
        }
        System.out.println("Please enter doctor's name");
        String doctorName = scanner.nextLine();
        System.out.println("Please enter doctor's surname");
        String doctorSurname = scanner.nextLine();
        System.out.println("Please enter doctor's phone");
        String doctorPhone = scanner.nextLine();
        System.out.println("Please enter doctor's email");
        String doctorEmail = scanner.nextLine();
        System.out.println("Please enter doctor's profession");
        String doctorProfession = scanner.nextLine();
        Doctor changedDoctor = doctorStorage.getById(doctorId);
        // updating doctor's information
        changedDoctor.setName(doctorName);
        changedDoctor.setSurname(doctorSurname);
        changedDoctor.setPhone(doctorPhone);
        changedDoctor.setEmail(doctorEmail);
        changedDoctor.setProfession(doctorProfession);
        System.out.println("Doctor's information was changed");
        System.out.println(changedDoctor);
        System.out.println();
    }

    private static void deleteDoctorById() {
        System.out.println("Please enter doctor's id from the list bellow"); // <- next 7 lines is for checking if we have a doctor with requested id
        doctorStorage.print();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with \'" + doctorId + "\" id does not exists!!!");
            return;
        }
        doctorStorage.deleteById(doctorId);
    }

    private static void printAllDoctors() {
        doctorStorage.print();
        System.out.println();
    }

    private static void searchDoctorByProfession() {
        System.out.println("Please enter doctor's profession"); // <- next 6 lines is for checking if we have a doctor with requested profession
        String profession = scanner.nextLine();
        Doctor[] professionFromStorage = doctorStorage.getByProfession(profession);
        if (professionFromStorage == null) {
            System.out.println("Profession with \'" + profession + "\' profession does not exists!!!");
            return;
        }
        for (Doctor doctor : professionFromStorage) {
            if (doctor != null) {
                System.out.println(doctor);
            }
        }
    }

    private static void addDoctor() {
        System.out.println("Please enter doctor's id"); // <- next 6 lines is for checking if we have a doctor with requested id
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage != null) {
            System.out.println("Doctor with " + doctorId + " id already exists!!!");
            return;
        }
        System.out.println("Please enter doctor's name");
        String doctorName = scanner.nextLine();
        System.out.println("Please enter doctor's surname");
        String doctorSurname = scanner.nextLine();
        System.out.println("Please enter doctor's phone");
        String doctorPhone = scanner.nextLine();
        System.out.println("Please enter doctor's email");
        String doctorEmail = scanner.nextLine();
        System.out.println("Please enter doctor's profession");
        String doctorProfession = scanner.nextLine();
        Doctor doctor = new Doctor(doctorId, doctorName, doctorSurname, doctorPhone, doctorEmail, doctorProfession);
        doctorStorage.add(doctor);
        System.out.println("Doctor is registered!");
    }

    private static void printCommands() {
        System.out.println("Please enter 0 to EXIT");
        System.out.println("Please enter 1 to ADD DOCTOR");
        System.out.println("Please enter 2 to SEARCH DOCTOR BY PROFESSION");
        System.out.println("Please enter 3 to DELETE DOCTOR BY ID");
        System.out.println("Please enter 4 to CHANGE DOCTOR BY ID");
        System.out.println("Please enter 5 to ADD PATIENT");
        System.out.println("Please enter 6 to PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Please enter 7 to PRINT ALL PATIENTS");
        System.out.println("Please enter 8 to PRINT ALL DOCTORS");
        System.out.println("Please enter 9 to DELETE A PATIENT");
    }
}