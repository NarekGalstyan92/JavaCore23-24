package classwork.chapter8;

class A {
    int i, j;

    A (int a, int b) {
        i = a;
        j = b;
    }
    A () {
        System.out.println("Inside A's constructor");
    }


    void showij() {
        System.out.println("i and j: " + i + " " + j);
    }

    void show() {
        System.out.println("i and j: " + i + " " + j);
    }

    void callMe() {
        System.out.println("Inside A's callMe() method");
    }
}
