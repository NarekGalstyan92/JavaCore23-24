package classwork.chapter8;

class B extends A {
    int k;

    B(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    B() {
        System.out.println("Inside B's constructor");
    }

    void showK() {
        System.out.println("K " + k);
    }

    @java.lang.Override
    void show() { // display k - this overrides show() in A
        super.show(); // this calls A's show()
        System.out.println("k: " + k);
    }

    void callMe() {
        System.out.println("Inside B's callMe() method");
    }
}
