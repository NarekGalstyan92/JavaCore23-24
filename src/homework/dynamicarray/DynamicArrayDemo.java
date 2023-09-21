package homework.dynamicarray;

public class DynamicArrayDemo {
    public static void main(String[] args) {

        DynamicArray dy = new DynamicArray();
        dy.addSmallNumbers(10); // using iteration adding numbers into array, value is the length
        dy.addLargeNumbers(501); // using iteration adding three-digit number, start point is 100. Increments by 100, value is the length
        dy.add(-74); // simply adding a number into array
        dy.print(); // printing all values of the array
        dy.getByIndex(0); //getting the value under given index
        dy.deleteByIndex(10); // deleting value with given index, moving to the left all other values, shortening size
        dy.set(2, 700); // Setting the value with given index in the array
        dy.add(0, 22); // adding value with given index, moving to the right all other values, enlarging size
        dy.exists(3); // checking if the value exist in array
        dy.getIndexByValue(500); // Return index of given value. If there are many - return first index

    }
}
