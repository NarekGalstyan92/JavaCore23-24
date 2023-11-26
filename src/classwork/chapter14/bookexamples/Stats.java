package classwork.chapter14.bookexamples;

// Stats attempts (unsuccessfully) to create a generic class that can compute
// the average of an array of numbers of any given type
class Stats<T extends Number> {
    T[] nums; // nums in an array of type T

    // Pass the constructor a reference to an array of type T.
    Stats(T[] o) {
        nums = o;
    }

    // return type double in all cases.
    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    // Determine if two averages are the same. Notice the use of wildcard.
    boolean sameAvg (Stats<?> ob){
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }
}
