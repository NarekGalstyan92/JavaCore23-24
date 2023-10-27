package classwork.chapter12;

public enum Language {
    HY("Հայերեն"),
    RU("Русский"),
    ENG("English");

    private String languageName;

    Language(String languageName) {
        this.languageName = languageName;
    }

    Language() {
    }

    public String getLanguageName() {
        return languageName;
    }
}
