package homework.chapter7.braceChecker;

public class BraceCheckerDemo {

    public static void main(String[] args) {

        String text = "Hello (from) [Java}";

        BraceChecker bc = new BraceChecker(text);
        bc.check();
    }
}
