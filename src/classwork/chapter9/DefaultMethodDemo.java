package classwork.chapter9;

class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIfImp obj = new MyIfImp();

        // Can call getNUmber(), because it is explicitly implemented by MYIfIpl
        System.out.println(obj.getNumber());

        // Can also call getString(), because of default implementation
        System.out.println(obj.getString());
    }
}
