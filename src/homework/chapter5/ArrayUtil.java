package homework.chapter5;

class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        // Տպել բոլոր էլեմենտները իրար կողք, բաժանված պռաբելով։
        System.out.print("The array contains following numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\n");
        // Տպել մասիվի առաջին էլեմենտը
        System.out.print("The first element in array is: " + numbers[0]);

        System.out.println("\n");

        // Տպել մասիվի վերջին էլեմենտը
        System.out.print("The last element in array is " + numbers[numbers.length - 1]);

        System.out.println("\n");

        // Տպել մասիվի երկարությունը
        System.out.print("Array length is: " + numbers.length);

        System.out.println("\n");

        //Տպել մասիվի ամենափոքր թիվը
        if (numbers.length > 0) {
            int minimal = numbers[0];
            for (int j : numbers) {
                if (j < minimal) {
                    minimal = j;
                }
            }
            System.out.print("The minimal element of the array is: " + minimal);
        } else {
            System.out.println("The array is empty");
        }

        System.out.println("\n");

        // Տպել մասիվի մեջտեղի թիվը, ստուգել որ 2-ից մեծ լինի երկարությունը,
        // եթե փոքր կամ հավասար էղավ, տպեք որ can't print middle values.
        // եթե զույգ է մասիվի մեջի էլեմենտների թիվը, տպեք մեջտեղի երկու էլեմենտները, եթե կենտ է մի հատը։

        if (numbers.length > 2) {
            if (numbers.length % 2 == 0) { //this line will work if the array values are even
                System.out.print("The middle values of the array are: " + numbers[(numbers.length / 2) - 1] + " and " + numbers[numbers.length / 2]);
            } else { //this line will work if the array values are odd
                System.out.print("The middle value of the array is: " + numbers[numbers.length / 2]);
            }
        } else if (numbers.length <= 2) { //this line will work if the array contains 2 or fewer values
            System.out.print("Can't print middle values");
        }


        System.out.println("\n");

        // Հաշվել ու տպել մասիվում զույգերի քանակը։
        int even = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            }
        }
        System.out.print("The count of even numbers in array is: " + even);

        System.out.println("\n");

        // Հաշվել ու տպել մասիվում կենտերի քանակը։
        int odd = 0;
        for (int number : numbers) {
            if (Math.abs(number) % 2 == 1) { // I used Math.abs, because Java can't check if the negative number is odd or even. Greetings from Glendale Community collage)))
                odd++;
            }
        }
        System.out.print("The count of odd numbers in array is: " + odd);

        System.out.println("\n");

        // Տպել մասիվում էլեմենտների գումարը։
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.print("Summary of all elements in the array is: " + sum);

        System.out.println("\n");

        // Տպել մասիվում թվերի միջին թվաբանականը։
        int summary = 0;
        for (int number : numbers) {
            summary += number;
        }
        double average = (double) summary / 2;
        System.out.println("The average number in the array is: " + average);
    }
}
