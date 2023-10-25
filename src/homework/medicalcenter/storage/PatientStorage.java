package homework.medicalcenter.storage;

import homework.medicalcenter.exceptions.PatientNotFoundException;
import homework.medicalcenter.model.Patient;

public class PatientStorage {
    private Patient[] patients = new Patient[10];
    private int size;

    public void add(Patient patient) {
        if (size == patients.length) {
            extend();
        }
        patients[size++] = patient;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i]);
        }
    }

    private void extend() {
        Patient[] tmp = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, tmp, 0, patients.length);
        patients = tmp;
    }

    public Patient getById(String patientId) throws PatientNotFoundException {
        for (int i = 0; i < size; i++) {
            if (patients[i].getId().equals(patientId)) {
                return patients[i];
            }
        }
        throw new PatientNotFoundException("Patient with " + patientId + " does not exist!");
    }

    public void deleteById(String patientId) {
        int indexById = getIndexById(patientId);
        if (indexById == -1) {
            System.out.println("Patient does not exists!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            patients[i - 1] = patients[i];
        }
        size--;
        System.out.println("Patient with \'" + patientId + "\' was deleted!!!");
    }

    private int getIndexById(String patientId) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getId().equals(patientId)) {
                return i;
            }
        }
        return -1;
    }

    public Patient[] getPatientsByDoctorId(String doctorId) {
        Patient[] patientsByDoctor = new Patient[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (patients[i] != null) {
                patientsByDoctor[j] = patients[i];
                j++;
            }
        }
        if (patientsByDoctor[0] != null) {
            return patientsByDoctor;
        }
        return null;
    }
}
