package classwork.chapter14.bookexamples;

class GenIFDemo {
    public static void main(String[] args) {
        Integer [] iNums = {3, 6, 2, 8, 6};
        Character [] chs = {'b', 'r', 'p', 'w'};

        MyClass<Integer> iOb = new MyClass<>(iNums);
        MyClass<Character> cOb = new MyClass<>(chs);

        System.out.println("Max value is iNums: " + iOb.max());
        System.out.println("Min value is iNums: " + iOb.min());
        System.out.println("Max value is chs: " + cOb.max());
        System.out.println("Min value is chs: " + cOb.min());
    }
}
