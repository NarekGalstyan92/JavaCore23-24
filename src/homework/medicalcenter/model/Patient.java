package homework.medicalcenter.model;

public class Patient extends Person {

    private String id;
    private Doctor doctor;
    private String date;

    public Patient(String name, String surname, String phone, String id, Doctor doctor, String date) {
        super(name, surname, phone);
        this.id = id;
        this.doctor = doctor;

        this.date = date;
    }

    public Patient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    // For more memory-efficient tasks I used a StringBuilder class.
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Patient{");
        stringBuilder.append("name='").append(name).append("', ");
        stringBuilder.append("surname='").append(surname).append("', ");
        stringBuilder.append("phone='").append(phone).append("', ");
        stringBuilder.append("id='").append(id).append("', ");
        stringBuilder.append("doctor='").append(doctor.getName()).append(" ").append(doctor.getSurname()).append("', ");
        stringBuilder.append("registration date='").append(date).append("'}");
        return stringBuilder.toString();
    }
}
