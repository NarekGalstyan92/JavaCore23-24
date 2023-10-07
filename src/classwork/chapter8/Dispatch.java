package classwork.chapter8;

class Dispatch {
    public static void main(String[] args) {
        A a = new A(); // object of type A
        B b = new B(); // object of type B
        C c = new C(); // object of type C

        A r; // obtain a reference of type A

        r = a; // r refers to an A object
        r.callMe(); // calls A's version of call me

        r = b; // r refers to an B object
        r.callMe(); // calls B's version of call me

        r = c; // r refers to an C object
        r.callMe(); // calls C's version of call me

    }
}
