package homework.medicalcenter.model;

import java.util.Date;

public class Patient extends Person {
    private Doctor doctor;
    private Date dateOfBirth;
    private Date registerDate;
    private Date appointmentDateTime;

    public Patient(String id, String name, String surname, String email, String phone, Date dateOfBirth, Date registerDate, Doctor doctor, Date appointmentDateTime) {
        super(id, name, surname, email, phone);
        this.doctor = doctor;
        this.dateOfBirth = dateOfBirth;
        this.registerDate = registerDate;
        this.appointmentDateTime = appointmentDateTime;
    }

    public Patient() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(Date appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    // For more memory-efficient tasks I used a StringBuilder class.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient{");
        sb.append(", id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", birthday= ").append(dateOfBirth);
        sb.append(", registration date= ").append(registerDate);
        sb.append(" doctor= ").append(doctor.name).append(" ").append(doctor.surname);
        sb.append(", appointment date and time= ").append(appointmentDateTime);
        sb.append("}");
        return sb.toString();
    }

}
