package homework.chapter7.braceChecker;

// This class defines an integer stack that can hold 10 values
class Stack {
    char[] stck = new char[10]; // destination of this array is to keep characters in it
    int[] intStck = new int[10]; // destination of this array is to keep indexes of the characters in it
    int tos;

    // Initialize top-of-stack
    Stack() {
        tos = -1;
    }

    // Push an item onto the stack
    void push(char symbol, int position) {
        if (tos == stck.length | tos == intStck.length) {
            extend();
        }
        if (tos == 9) {
            System.out.println("Stack is full");
        } else {
            stck[++tos] = symbol;
            intStck[tos] = position;
        }
    }

    // Pop an item from the stack
    int pop() {
        if (tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return stck[tos--];
        }
    }

    private void extend() {
        char[] temp = new char[stck.length + 10];
        System.arraycopy(stck, 0, temp, 0, stck.length);
        stck = temp;

        int[] intTemp = new int[intStck.length + 10];
        System.arraycopy(intStck, 0, temp, 0, intTemp.length);
        intStck = intTemp;

    }
}
