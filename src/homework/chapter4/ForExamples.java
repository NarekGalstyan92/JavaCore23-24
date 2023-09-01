package homework.chapter4;

public class ForExamples {
    public static void main(String[] args) {

//example #1
// Տպել 1-ից 1000 թվերը իրար կողք, արանքում դնելով - սինվոլը։ Այնպես գրեք, որ վերջում - չլինի։
        int k = 1000;
        for (int i = 1; i <= k; i++) {
            System.out.print(i);
            if (i < k) {
                System.out.print("-");
            }
        }
        // Output: 1-2-3-4....998-999-1000

        System.out.println("\n");


// example #2
// Տպել 1-ից 100 թվերի մեջ ընկած զույգերը օգտագործելով % գործողությունը։

        k = 100;
        for (int i = 1; i <= k; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        // Output: 2 4 6 8 10......92 94 96 98 100

        System.out.println("\n");


//example #3 V1.0 (My favorite version)
// Հայտարարել թվերի մասիվ՝ int[] array = {2,5,8,4,9,3,7}, ֆոր- օգտագործելով գտնել մասիվի ամենամեծ թիվը ու տպել։

        int[] arrayTwo = {65, 73, 112, 8, -200};
        int largestValue = Integer.MIN_VALUE; //will work for all integer numbers including positive and negative numbers
        for (int i = 0; i < arrayTwo.length; i++) {
            if (arrayTwo[i] > largestValue) {
                largestValue = arrayTwo[i];
            }
        }
        if (largestValue == -2147483648) {
            System.out.println("Sorry, but the array is empty"); // to make this line work delete all numbers from array
        } else {
            System.out.print(largestValue);
        }


        System.out.println("\n");

//example #3 V2.0
// Հայտարարել թվերի մասիվ՝ int[] array = {2,5,8,4,9,3,7}, ֆոր- օգտագործելով գտնել մասիվի ամենամեծ թիվը ու տպել։

        int[] array = {2, 5, 8, 4, 9, 3, 7, 65, 73, 112, 8, 0, -200, 345};
        int x = 0; //(will work only if we have even 1 positive number or 0 in array. For negative numbers this code won't work)
        for (int i = 1; i < array.length; i++) {

            if (array[i] > array[i - 1] & array[i] > x) {
                x = array[i];
            }
        }
        if (x == 0) {
            System.out.println("Sorry, but the array is empty or it contains only \"0\""); // to make this line work delete all numbers from array or put there "0"
        } else {
            System.out.print(x);
        }

        System.out.println("\n");

//example #3 V3.0
// Հայտարարել թվերի մասիվ՝ int[] array = {2,5,8,4,9,3,7}, ֆոր- օգտագործելով գտնել մասիվի ամենամեծ թիվը ու տպել։

        int[] arrayThree = {2, 5, 8, 4, 9, 3, 7, -120, -40, 0, 2, 6, 8, 3, 234, 1};
        int min = arrayThree[0]; //will work for all integers, but not for empty array
        for (int i = 0; i < arrayThree.length; i++) {
            if (arrayThree[i] > min) {
                min = arrayThree[i];
            }
        }
        System.out.print(min);

        System.out.println("\n");

//example #3 V3.1
// Հայտարարել թվերի մասիվ՝ int[] array = {2,5,8,4,9,3,7}, ֆոր- օգտագործելով գտնել մասիվի ամենամեծ թիվը ու տպել։

        int[] arrayFour = {2, 5, 8, 4, 9, 3, 7, 20, -90, 78643, 1, 1, 1, 23, 0, 765, -765};
        int minimal = arrayFour[0]; //will work for all integers, but not for empty array
        for (int j : arrayFour) { // "for" loop replaced with "for each".
            if (j > minimal) {
                minimal = j;
            }
        }
        System.out.print(minimal);

        System.out.println("\n");
    }
}
