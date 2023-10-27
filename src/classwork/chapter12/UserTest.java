package classwork.chapter12;

public class UserTest {
    public static void main(String[] args) {
        String lang = "Hy";
        // demonstration of valueOf() method
        Language language = Language.valueOf(lang.toUpperCase());

        User user = new User("Poxos", "Poxosyan", "poxosyan@gmail.com", language);
        User user1 = new User("Petros", "Petrosyan", "petrosyan@gmail.com", Language.RU);
//        String lang = user.getLang().name();
        System.out.println(user);

        // demonstration of values() method
        Language[] values = Language.values();
        for (Language value : values) {
            System.out.println(value + " " + value.getLanguageName() + " " + value.ordinal());
        }
    }
}
