package classwork.chapter10;

import java.util.Random;

// Handle an exception and move on
class HandleError {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;

        Random r = new Random();
        for (int i = 0; i < 32; i++) {
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b/c);
            } catch (ArithmeticException e) {
                System.out.println("Division by zero");
                a = 0; // set "a" to zero and continue
            }
            System.out.println("a = " + a);
        }
    }
}
