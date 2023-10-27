package classwork.chapter12;

// Use a built-in enumeration methods

// An enumeration of apple varieties
class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Here are all Apple constants");

        // use Values()
        Apple[] allApples = Apple.values(); // <-- we could write this two lines using other option (just 1 line)
        for (Apple a : allApples) {         // <-- for(Apple a: Apple.values())
            System.out.println(a);
        }
        System.out.println();

        // use valueOf()
        ap = Apple.valueOf("Winesap");
        System.out.println("ap contains: " + ap);
    }
}
