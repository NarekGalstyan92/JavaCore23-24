package classwork.chapter14.bookexamples;

// Demonstrate a simple generic method
class GenMethDemo {

    public static void main(String[] args) {
        // Use isIn() on Integers
        Integer [] nums = {1, 2, 3, 4, 5};

        if (isIn(2, nums)){
            System.out.println("2 is in nums");
        }

        if (!isIn(7, nums)) {
            System.out.println("7 is not in nums");
        }

        // Use isIn on Strings
        String[] strs = {"one", "two", "three", "four", "five"};

        if (isIn("two", strs)) {
            System.out.println("two is in strs");
        }

        if (!isIn("seven", strs)) {
            System.out.println("seven is not in strs");
        }

        // The code below won't compile because of a compile-time type-mismatch error
        /*
        if (isIn("two", nums)){
            System.out.println("two is in strs");
        }
         */
    }

    // Determine if an object is in array.
    static  <T extends Comparable<T>, V extends T> boolean isIn(T x, V [] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])){
                return true;
            }
        }
        return false;
    }
}
