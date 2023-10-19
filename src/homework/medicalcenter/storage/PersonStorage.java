package homework.medicalcenter.storage;

import homework.medicalcenter.model.Doctor;
import homework.medicalcenter.model.Patient;
import homework.medicalcenter.model.Person;

import java.util.Calendar;
import java.util.Date;

public class PersonStorage {

    private Person[] people = new Person[10];
    private int size;

    public void add(Person person) {
        if (size == people.length) {
            extend();
        }
        people[size++] = person;
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor) {
                System.out.println(people[i]);
            }
        }
    }

    public void printAllPatients() {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient)
                System.out.println(people[i]);
        }
    }

    private void extend() {
        Person[] tmp = new Person[people.length + 10];
        System.arraycopy(people, 0, tmp, 0, people.length);
        people = tmp;
    }

    public Person getDoctorById(String personId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor && people[i].getId().equals(personId)) {
                return people[i];
            }
        }
        return null;
    }

    public Person getPatientById(String personId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && people[i].getId().equals(personId)) {
                return people[i];
            }
        }
        return null;
    }

    public void deleteDoctorById(String personId) {
        int indexById = getDoctorIndexById(personId);
        if (indexById == -1) {
            System.out.println("Person does not exists!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            if (people[i] instanceof Doctor) {
                people[i - 1] = people[i];
            }
        }
        size--;
        System.out.println("Doctor with \'" + personId + "\' was deleted!!!");
    }

    public void deletePatientById(String personId) {
        int indexById = getPatientIndexById(personId);
        if (indexById == -1) {
            System.out.println("Person does not exists!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            if (people[i] instanceof Patient) {
                people[i - 1] = people[i];
            }
        }
        size--;
        System.out.println("Patient with \'" + personId + "\' was deleted!!!");
    }

    public Person[] getPatientByDoctorId(String doctorId) {
        Person[] patientByDoctor = new Person[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && people[i] != null) {
                patientByDoctor[j] = people[i];
                j++;
            }
        }
        if (patientByDoctor[0] != null) {
            return patientByDoctor;
        }
        return null;
    }

    public boolean isAppointmentTimeAvailable(Doctor doctor, Date appointmentDateTime) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient) {
                if (patient.getDoctor().getId().equals(doctor.getId())) { // finding the doctor from the list of patients
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(patient.getAppointmentDateTime()); // setting to calendar the time of the appointment
                    calendar.add(Calendar.MINUTE, 29); // adding 29 minutes to the calendar
                    Date appointmentDateTimePlus30Min = calendar.getTime(); // assigning the 30 after-minutes to a variable of a Date object
                    if (appointmentDateTime.before(appointmentDateTimePlus30Min)) // checking if the busy app time is before the inputted app time
                        return false;
                }
                if (patient.getDoctor().getId().equals(doctor.getId())) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(patient.getAppointmentDateTime());
                    calendar.add(Calendar.MINUTE, -29);
                    Date appointmentDateTimeMinus30Min = calendar.getTime();
                    if (appointmentDateTime.after(appointmentDateTimeMinus30Min))
                        return false;
                }
            }
        }
        return true;
    }

    private int getDoctorIndexById(String personId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor && people[i].getId().equals(personId)) {
                return i;
            }
        }
        return -1;
    }

    private int getPatientIndexById(String personId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && people[i].getId().equals(personId)) {
                return i;
            }
        }
        return -1;
    }
}
