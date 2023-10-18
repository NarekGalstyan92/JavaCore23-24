package classwork.chapter9;

// Another implementation of Callback
class AnotherClient implements Callback {

    // Implement Callback's interface

    @Override
    public void callBack(int p) {
        System.out.println("Another version of callback");
        System.out.println("p squared is " + p * p);
    }
}
