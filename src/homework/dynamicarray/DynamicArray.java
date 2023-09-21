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
        System.out.println();
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
            System.out.println("Value " + i + " added to array.");
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
        System.out.println("\nThe array was extended.\n");
        System.out.println();
        temp = null; // losing the reference of temp, so GC can sure clean the heap
    }

    // if the given index is within the range of the array,
    // return the element under that index. Otherwise, return -1.
    public int getByIndex(int index) {
        if (checkIndexExisting(index)) {
            System.out.println("Value under index " + index + " is returned, and it was " + array[index] + ".\n");
            return array[index];
        }

        System.out.println("Couldn't get value with given index! There is no such element under index " + index + ".");
        System.out.println();
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

    //delete the element of the array under given index
    //if there is no element with such index, print that there is no such element
    public void deleteByIndex(int index) {
        if (!checkIndexExisting(index)) {
            System.out.println("Value deleting failed! There is no such element under index " + index + ".");
        } else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0; // assigning last element of the array 0 to clear the given index from data
            size--; // changing size length to lose last element
            System.out.println("Value under index " + index + " was deleted successfully!");
            System.out.println("Array was updated!");
            print();
            System.out.println();
        }
    }

    // Set the value under given index.
    // If there is no element with such index, print that there is no such element
    public void set(int index, int value) {
        if (!checkIndexExisting(index)) {
            System.out.println("Setting value \"" + value + "\" with given index failed! There is no such element under index " + index + ".");
        } else {
            array[index] = value;
            System.out.println("Value ander index " + index + " was changed successfully!");
            System.out.println("Array was updated.");
            print();
            System.out.println();
        }
    }

    //Add a value into array with given index, move other elements to the right
    // If there is no element with such index, print that there is no such element
    public void add(int index, int value) {
        if (!checkIndexExisting(index)) {
            System.out.println("Adding value \"" + value + "\" with given index failed! There is no such element under index " + index + ".");
            System.out.println();
        } else {
            size++; //enlarging the size so elements in array can be moved to the right
            if (size >= array.length) {
                extend();
            }
            for (int i = size; i > index; i--) { // moving elements to the right
                array[i] = array[i - 1];
            }
            array[index] = value; // setting value into given index
            System.out.println("Array was updated!");
            print();
            System.out.println();
        }
    }

    //Return true if the value exist in array and false if it doesn't
    public boolean exists(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                System.out.println("Value \"" + value + "\" exist!\n");
                return true;
            }
        }
        System.out.println("Value \"" + value + "\" doesn't exist!\n");
        return false;
    }

    //Return index of given value. If there are many - return first index. If there isn't any matching - return -1.
    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                System.out.println("Index returned (" + i + ")\n");
                return i;
            }
        }
        System.out.println("Couldn't get any matching with given value \"" + value + "\".");
        return -1;
    }

    // checking if the given index is in the range from 0 to size.
    private boolean checkIndexExisting(int index) {
        return index >= 0 && index < size;
    }
}

