package classwork.chapter7;

// Use varargs with standard arguments.
class VarArgs2 {

    // Here, msg is a normal parameter and v is a
    // varargs parameter
    static void vaTest(String msg, int... v) {
        System.out.print(msg + v.length + " Contents: ");
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        vaTest("One vararg: ", 10); // 1 arg
        vaTest("Three varargs: ", 1, 2, 3); // 3 args
        vaTest("No varargs: "); // no args
    }
}
