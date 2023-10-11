package classwork.chapter8;

// A simple demonstration of abstract
abstract class AbstractA {

    abstract void callMe();

    // concrete methods are still allowed in abstract classes
    void  callMeToo() {
        System.out.println("This is a concrete method");
    }
}
