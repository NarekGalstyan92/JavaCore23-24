package classwork.chapter9;

public class MyIfIpl2 implements MyIf{

    // Here implementations for both getNumber() and getString() are provided

    @Override
    public int getNumber() {
        return 100;
    }

    @Override
    public String getString() {
        return "This is a different string";
    }
}
