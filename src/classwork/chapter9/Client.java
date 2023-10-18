package classwork.chapter9;

class Client implements Callback {

    public void callBack(int p) {
        System.out.println("callback called with " + p);
    }

    void nonIfaceMeth() {
        System.out.println("Classes that implement interfaces may also define other members too");
    }
}
