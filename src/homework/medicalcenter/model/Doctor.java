package homework.medicalcenter.model;

public class Doctor extends Person {

    private String id;
    private String email;
    private String profession;

    public Doctor(String id, String name, String surname, String phone, String email, String profession) {
        super(name, surname, phone);
        this.id = id;
        this.email = email;
        this.profession = profession;
    }

    public Doctor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    // For more memory-efficient tasks I used a StringBuilder class.
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Doctor{");
        stringBuilder.append("id='").append(id).append("', ");
        stringBuilder.append("name='").append(name).append("', ");
        stringBuilder.append("surname='").append(surname).append("', ");
        stringBuilder.append("phone='").append(phone).append("', ");
        stringBuilder.append("email='").append(email).append("', ");
        stringBuilder.append("profession='").append(profession).append("'}");
        return stringBuilder.toString();
    }
}
