package homework.medicalcenter.storage;

import homework.medicalcenter.exceptions.DoctorNotFoundException;
import homework.medicalcenter.model.Doctor;

public class DoctorStorage {
    private Doctor[] doctors = new Doctor[10];
    private int size;

    public void add(Doctor doctor) {
        if (size == doctors.length) {
            extend();
        }
        doctors[size++] = doctor;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    private void extend() {
        Doctor[] tmp = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, tmp, 0, doctors.length);
        doctors = tmp;
    }

    public Doctor getById(String doctorId) throws DoctorNotFoundException {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(doctorId)) {
                return doctors[i];
            }
        }
        throw new DoctorNotFoundException("Doctor with " + doctorId + " not found!");
    }

    public void deleteById(String doctorId) {
        int indexById = getIndexById(doctorId);
        if (indexById == -1) {
            System.out.println("Doctor does not exists!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            doctors[i - 1] = doctors[i];
        }
        size--;
        System.out.println("Doctor with \'" + doctorId + "\' was deleted!!!");
    }

    private int getIndexById(String companyId) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(companyId)) {
                return i;
            }
        }
        return -1;
    }

    public Doctor[] getByProfession(String profession) {
        Doctor[] doctorsWithSameProfession = new Doctor[size];
        for (int i = 0; i < size; i++) { // adding to array all doctors with the same profession
            if (doctors[i].getProfession().equals(profession)) {
                doctorsWithSameProfession[i] = doctors[i];
            }
        }
        for (int i = 0; i < doctorsWithSameProfession.length; i++) { // checking if the array is empty. If yes - return null
            if (doctorsWithSameProfession[0] == null) {
                return null;
            }
        }
        return doctorsWithSameProfession; // in this array there should be at least 1 doctor with requested profession
    }
}
