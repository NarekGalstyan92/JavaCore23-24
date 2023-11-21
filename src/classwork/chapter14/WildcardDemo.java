package classwork.chapter14;

// Demonstrate wildcard
class WildcardDemo {
    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3, 4, 5};
        Stats<Integer> iOb = new Stats<>(inums);
        double v = iOb.average();
        System.out.println("iOb average is " + v);

        Double [] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dOb = new Stats<>(dnums);
        double w = dOb.average();
        System.out.println("dOb average is " + w);

        Float [] fnums = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F, };
        Stats<Float> fOb = new Stats<>(fnums);
        double x =fOb.average();
        System.out.println("fOb average is " + w);

        // See which arrays have same average.
        System.out.print("Averages of iOb and dOb ");
        if (iOb.sameAvg(dOb)) {
            System.out.println("are the same.");
        }else {
            System.out.println("differ.");
        }

        System.out.print("Averages of iOb and fOb ");
        if (iOb.sameAvg(fOb)) {
            System.out.println("are the same.");
        }else {
            System.out.println("differ.");
        }
    }
}
