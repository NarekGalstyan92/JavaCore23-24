package classwork.chapter5;

class ForEach {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;

        // use for-each style to display and sum the values
        for (int num : nums) {
            System.out.println("Value is: " + num);
            sum += num;
        }
        System.out.println("Summation: " + sum);
    }
}
