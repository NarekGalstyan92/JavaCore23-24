package homework.dynamicarray;

public class DynamicArrayDemo {
    public static void main(String[] args) {

        DynamicArray dy = new DynamicArray();
        dy.addSmallNumbers(10); // using iteration adding numbers into array, value is the length
        dy.addLargeNumbers(500); // using iteration adding three-digit number, start point is 100. Increments by 100
        dy.add(-74); // simply adding a number into array
        dy.print(); // printing all values of the array
        dy.getByIndex(15);

    }
}
