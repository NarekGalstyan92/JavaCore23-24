package homework.chapter3;

public class IfSample {
    public static void main(String[] args) {
        byte a =15;
        byte b = 20;
        System.out.println(a * b);
        System.out.println();
        int c = 615;
        float d = 14.5f;
        double i = (c * d) / b;
        System.out.println(i);
        System.out.println();
        for (int j = a; j < b; j++) {
            System.out.println("some text " + j);
        }
        System.out.println();
        int l = c * 5;
        char n = '\u0025';
        System.out.print(n + "" + l);

    }
}
