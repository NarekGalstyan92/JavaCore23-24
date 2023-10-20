package homework.medicalcenter.model;

public class Doctor extends Person {

    private String profession;

    public Doctor(String id, String name, String surname, String email, String phone, String profession) {
        super(id, name, surname, email, phone);
        this.profession = profession;
    }

    public Doctor() {
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
        StringBuilder sb = new StringBuilder();
        sb.append("Doctor{");
        sb.append("profession= '").append(profession).append('\'');
        sb.append(", id= '").append(id).append('\'');
        sb.append(", name= '").append(name).append('\'');
        sb.append(", surname= '").append(surname).append('\'');
        sb.append(", email= '").append(email).append('\'');
        sb.append(", phone= '").append(phone).append('\'');
        sb.append("}");
        return sb.toString();
    }
}
