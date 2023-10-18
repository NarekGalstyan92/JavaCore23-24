package classwork.chapter9;

class TestIface2 {
    public static void main(String[] args) {
        Callback c = new Client();
        AnotherClient ob = new AnotherClient();

        c.callBack(42);

        c = ob; // c now refers to AnotherClient object
        c.callBack(42);
    }
}
