package classwork.chapter5;

// Use break with a for-each style for
class ForEach2 {
    public static void main(String[] args) {
        int sum = 0;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // use for to display and sum the values.
        for (int num : nums) {
            System.out.println("Value is: " + num);
            sum += num;

            if (num == 5) {
                break; // stop the loop when 5 is obtained.
            }
        }
        System.out.println("Summation of first 5 elements: " + sum);
    }
}
