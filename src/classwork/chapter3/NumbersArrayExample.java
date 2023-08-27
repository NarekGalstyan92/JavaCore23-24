package classwork.chapter3;

 class NumbersArrayExample {
     public static void main(String[] args) {
         int [] numbers = {3, 6, 1, 7, 9, 2, 8, 9, 5, 4, 33, 22, 11};
         System.out.println(numbers[0]);
         System.out.println(numbers[numbers.length - 1]);
         for (int i = 0; i < numbers.length; i++) {
             System.out.print(numbers[i] + " ");
         }
     }
}
