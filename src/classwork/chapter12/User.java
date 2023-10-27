package classwork.chapter12;

class User {
    private String name;
    private String surname;
    private String email;
    private Language lang;

    public User(String name, String surname, String email, Language lang) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.lang = lang;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
