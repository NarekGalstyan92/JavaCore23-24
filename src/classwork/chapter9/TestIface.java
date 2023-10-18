package classwork.chapter9;

class TestIface {

    public static void main(String[] args) {
        Callback c = new Client();
        c.callBack(42);
    }

}
