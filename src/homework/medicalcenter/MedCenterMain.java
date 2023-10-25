package homework.medicalcenter;

import homework.medicalcenter.exceptions.DoctorNotFoundException;
import homework.medicalcenter.exceptions.PatientNotFoundException;
import homework.medicalcenter.util.DateUtil;
import homework.medicalcenter.model.Doctor;
import homework.medicalcenter.model.Patient;
import homework.medicalcenter.storage.DoctorStorage;
import homework.medicalcenter.storage.PatientStorage;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MedCenterMain implements Command {

    private static Scanner scanner = new Scanner(System.in);
    private static DoctorStorage doctorStorage = new DoctorStorage();
    private static PatientStorage patientStorage = new PatientStorage();

    public static void main(String[] args) {

        // list of ready doctors and patients for test
        // Doctors id starts with 'D'
        // Patients id starts with 'P'
        Date dateOfB1 = null;
        Date dateOfB2 = null;
        Date dateOfB3 = null;
        Date dateOfB4 = null;
        Date appointmentDateTime1 = null;
        Date appointmentDateTime2 = null;
        Date appointmentDateTime3 = null;
        Date appointmentDateTime4 = null;
        try {
            dateOfB1 = DateUtil.stringToDate("20-10-1990");
            dateOfB2 = DateUtil.stringToDate("13-08-1993");
            dateOfB3 = DateUtil.stringToDate("08-03-1988");
            dateOfB4 = DateUtil.stringToDate("19-06-2002");
            appointmentDateTime1 = DateUtil.stringToDateTime("20-10-2022 10:00");
            appointmentDateTime2 = DateUtil.stringToDateTime("20-10-2022 10:30");
            appointmentDateTime3 = DateUtil.stringToDateTime("20-10-2022 11:00");
            appointmentDateTime4 = DateUtil.stringToDateTime("20-10-2022 11:30");
        } catch (ParseException e) {
            System.out.println("Failed to add patient!");
        }
        Date registerDate = new Date();
        Doctor doctor1 = new Doctor("D001", "Poxos", "Poxosyan", "+37499112233", "poxospoxosyan@gmail.com", "Anesthesiologist");
        Doctor doctor2 = new Doctor("D002", "Petros", "Petrosyan", "+37499332211", "petrospetrosyan@gmail.com", "Cardiologist");
        Doctor doctor3 = new Doctor("D003", "Martiros", "Martirosyan", "+37499221133", "martirosmartirosyan@gmail.com", "Nurse");
        Doctor doctor4 = new Doctor("D004", "Mamikon", "Mamikonyan", "+37443113487", "mamikonmamikonyan@gmail.com", "Orthodontist");
        Patient patient1 = new Patient("P001", "John", "Wick", "johnwick@gmail.com", "(818)5607865", dateOfB1, registerDate, doctor1, appointmentDateTime1);
        Patient patient2 = new Patient("P002", "Mike", "Wazovski", "mikewazovski@gmail.com", "(818)1234567", dateOfB2, registerDate, doctor2, appointmentDateTime2);
        Patient patient3 = new Patient("P003", "Bob", "Hamilton", "bobhamilton@gmail.com", "(818)7654321", dateOfB3, registerDate, doctor3, appointmentDateTime3);
        Patient patient4 = new Patient("P004", "Jack", "Sparrow", "jacksparraw@gmail.com", "(818)0987654", dateOfB4, registerDate, doctor1, appointmentDateTime4);
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
            Command.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case ADD_PATIENT:
                    try {
                        addPatient();
                    } catch (ParseException e) {
                        System.out.println(e.getMessage() + "Failed to add patient!");
                    }
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printAllPatientsByDoctor();
                    break;
                case PRINT_ALL_PATIENTS:
                    printAllPatients();
                    break;
                case PRINT_ALL_DOCTORS:
                    printAllDoctors();
                    break;
                case DELETE_A_PATIENT:
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
        Patient patientFromStorage = null;
        try {
            patientFromStorage = patientStorage.getById(patientId);
        } catch (PatientNotFoundException e) {
            e.getMessage();
        }
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
        Doctor doctorFromStorage = null;
        try {
            doctorFromStorage = doctorStorage.getById(doctorId);
        } catch (DoctorNotFoundException e) {
            e.getMessage();
        }
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

    private static void addPatient() throws ParseException {
        System.out.println("Please enter patient's id");// <- next 6 lines is for checking if we already have a patient with requested id
        String patientId = scanner.nextLine();
        Patient patientFromStorage = null;
        try {
            patientFromStorage = patientStorage.getById(patientId);
        } catch (PatientNotFoundException e) {
            e.getMessage();
        }
        if (patientFromStorage != null) {
            System.out.println("Patient with \'" + patientId + "\" id already exists!!!");
            return;
        }
        System.out.println("Please enter patient's name");
        String patientName = scanner.nextLine();
        System.out.println("Please enter patient's surname");
        String patientSurname = scanner.nextLine();
        System.out.println("Please enter patient's email");
        String patientEmail = scanner.nextLine();
        System.out.println("Please enter patient's phone");
        String patientPhone = scanner.nextLine();
        System.out.println("Please enter date of birth (dd-MM-yyyy)");
        String dateOfBirthStr = scanner.nextLine();
        Date dOb = DateUtil.stringToDate(dateOfBirthStr);
        Date registrationDate = new Date();
        System.out.println("Please choose patient doctor by doctor id");// <- next 7 lines is for checking if we have a doctor with requested id
        doctorStorage.print();
        String chosenDoctorForPatient = scanner.nextLine();
        Doctor doctorFromStorage = null;
        try {
            doctorFromStorage = doctorStorage.getById(chosenDoctorForPatient);
        } catch (DoctorNotFoundException e) {
            e.getMessage();
        }
        if (doctorFromStorage == null) {
            System.out.println("Doctor with \'" + chosenDoctorForPatient + "\" id does not exists!!!");
            return;
        }
        Doctor chosenDoctor = null; // getting doctor id to attach him/her to the patient file
        try {
            chosenDoctor = doctorStorage.getById(chosenDoctorForPatient);
        } catch (DoctorNotFoundException e) {
            e.getMessage();
        }
        System.out.println("Please enter appointment date and time (dd-MM-yyyy hh:mm)");
        String appointmentDateAndTimeStr = scanner.nextLine();
        Date appointmentDateAndTime = DateUtil.stringToDateTime(appointmentDateAndTimeStr);
        Patient patient = new Patient(patientId, patientName, patientSurname, patientEmail, patientPhone, dOb, registrationDate, chosenDoctor, appointmentDateAndTime);
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
        Doctor doctorFromStorage = null;
        try {
            doctorFromStorage = doctorStorage.getById(doctorId);
        } catch (DoctorNotFoundException e) {
            e.getMessage();
        }
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
        Doctor changedDoctor = null;
        try {
            changedDoctor = doctorStorage.getById(doctorId);
        } catch (DoctorNotFoundException e) {
            e.getMessage();
        }
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
        Doctor doctorFromStorage = null;
        try {
            doctorFromStorage = doctorStorage.getById(doctorId);
        } catch (DoctorNotFoundException e) {
            e.getMessage();
        }
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
        Doctor doctorFromStorage = null;
        try {
            doctorFromStorage = doctorStorage.getById(doctorId);
        } catch (DoctorNotFoundException e) {
            e.getMessage();
        }
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

}