package classwork.chapter9;

/*
Create an interface variable and
access stacks through it
 */
class IfTest3 {
    public static void main(String[] args) {
        IntStack myStack; // create an interface reference variable
        DynStack ds = new DynStack(5);
        FixedStack fs = new FixedStack(8);

        myStack = ds; // load dynamic stack
        // Push some numbers onto the stack
        for (int i = 0; i < 12; i++) {
            myStack.push(i);
        }
        myStack = fs;
        for (int i = 0; i < 8; i++) {
            myStack.push(i);
        }

        myStack = ds;
        // pop those numbers off the stack
        System.out.println("Stack in myStack1: ");
        for (int i = 0; i < 12; i++) {
            System.out.println(myStack.pop());
        }

        myStack = fs;
        System.out.println("Stack in myStack2: ");
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
    }
}
