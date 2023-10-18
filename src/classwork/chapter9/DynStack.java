package classwork.chapter9;

// Implement a "growable" stack
class DynStack implements IntStack {
    private int[] stck;
    private int tos;

    // allocate and initialize stack
    DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    // Push an item onto the stack
    @Override
    public void push(int item) {
        // if the stack is full, allocate a larger stack
        if (tos == stck.length - 1) {
            int[] tmp = new int[stck.length * 2];
            System.arraycopy(stck, 0, tmp, 0, stck.length);
            stck = tmp;
            stck[++tos] = item;
        } else {
            stck[++tos] = item;
        }
    }

    @Override
    public int pop() {
        if (tos < 0) {
            System.out.println("STack underflow.");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}
