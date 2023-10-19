package homework.medicalcenter;

public interface Command {

    String EXIT = "0";
    String ADD_DOCTOR = "1";
    String SEARCH_DOCTOR_BY_PROFESSION = "2";
    String DELETE_DOCTOR_BY_ID = "3";
    String CHANGE_DOCTOR_BY_ID = "4";
    String ADD_PATIENT = "5";
    String PRINT_ALL_PATIENTS_BY_DOCTOR = "6";
    String PRINT_ALL_PATIENTS = "7";
    String PRINT_ALL_DOCTORS = "8";
    String DELETE_A_PATIENT = "9";


    static void printCommands() {
        System.out.println("Please enter " + EXIT + " to EXIT");
        System.out.println("Please enter " + ADD_DOCTOR + " to ADD DOCTOR");
        System.out.println("Please enter " + SEARCH_DOCTOR_BY_PROFESSION + " to SEARCH DOCTOR BY PROFESSION");
        System.out.println("Please enter " + DELETE_DOCTOR_BY_ID + " to DELETE DOCTOR BY ID");
        System.out.println("Please enter " + CHANGE_DOCTOR_BY_ID + " to CHANGE DOCTOR BY ID");
        System.out.println("Please enter " + ADD_PATIENT + " to ADD PATIENT");
        System.out.println("Please enter " + PRINT_ALL_PATIENTS_BY_DOCTOR + " to PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Please enter " + PRINT_ALL_PATIENTS + " to PRINT ALL PATIENTS");
        System.out.println("Please enter " + PRINT_ALL_DOCTORS + " to PRINT ALL DOCTORS");
        System.out.println("Please enter " + DELETE_A_PATIENT + " to DELETE A PATIENT");
    }
}
