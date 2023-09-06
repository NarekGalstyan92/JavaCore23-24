package classwork.chapter5;

// The for-each loop is essentially read-only
class NoChange {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int num : nums) {
            System.out.print(num + " ");
            ;
            num = num * 10;
        }
        System.out.println();

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
