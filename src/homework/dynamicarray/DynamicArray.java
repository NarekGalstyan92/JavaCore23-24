package homework.dynamicarray;

public class DynamicArray {
    private int[] array = new int[10]; // this is our main array, where we are going to save added elements
    private int size = 0; // this is the count of added elements

    //call extend() if there is no more space in array and then add
    public void add(int value) { // adding simple integer into array
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
        System.out.println("Value " + value + " added to array");
    }

    // adding small integers into array using iteration.
    public void addSmallNumbers(int value) {
        for (int i = 0; i < value; i++) {
            if (size == array.length) {
                extend();
            }
            array[size++] = i;
            System.out.println("Value " + i + " added to array");
        }
    }

    // adding large integers into array using iteration.
    public void addLargeNumbers(int value) {
        for (int i = 100; i < value; i += 100) {
            if (size == array.length) {
                extend();
            }
            array[size++] = i;
            System.out.println("Value " + i + " added to array");
        }
    }


    //1․ Create an array 10 elements larger than the old array
    //2․ Copy the elements of the old array into the new one
    //3․ Link the reference of the old array with the reference of the new array
    private void extend() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) { // instead of "for" enhancement we could use  System.arraycopy(array, 0, temp, 0, array.length) to avoid manual copy
            temp[i] = array[i];
        }
        array = temp;
        System.out.println("\nThe array was extended\n");
        temp = null; // losing the reference of temp, so GC can sure clean the heap
    }

    // if the given index is within the index of the array we have,
    // return the element under that index. Otherwise, return -1.
    public int getByIndex(int index) {
        if (index >= 0 && index < size) {
            System.out.println("Value under index " + index + " is returned, and it was " + array[index] + "\n");
            return array[index];
        }
        System.out.println("Index is out of bounds for array length");
        return -1;
    }

    // printing all the elements of the array
    public void print() {
        System.out.print("The added element(s) is: ");
        for (int i = 0; i < size; i++) { // printing all the elements of the array but not the empty (default 0) ones
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

