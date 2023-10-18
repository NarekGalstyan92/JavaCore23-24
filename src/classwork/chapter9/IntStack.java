package classwork.chapter9;

// Define an integer stack interface
interface IntStack {
    void push(int item); // store an item

    int pop(); // retrieve an item


    // A default method that returns an array that contains the top n elements on the stack
    default int[] popNElements(int n) {
        // Return the requested elements
        return getElements(n);
    }

    // A default method that returns an array that contains the next n elements on the stack after skipping elements
    default int[] skipAndPopElements(int skip, int n) {

        // Skip the specified number of elements.
        getElements(skip);

        // Return the requested elements
        return getElements(n);

    }

    // A private method that returns an array containing the top n elements on the stack
    private int[] getElements(int n) {
        int[] elements = new int[n];

        for (int i = 0; i < n; i++) {
            elements[i] = pop();
        }
        return elements;
    }

    // Because clear() has a default, it needs to be implemented
    // by a preexisting class that uses IntStack.

    default void clear() {
        System.out.println("clear() not implemented");
    }
}
