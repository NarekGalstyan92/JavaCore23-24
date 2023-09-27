package homework.chapter7.braceChecker;

public class BraceChecker {

    private final String TEXT;

    // Passing parameter to constructor
    public BraceChecker(String text) {
        this.TEXT = text;
    }

    public void check() {
        Stack stack = new Stack();
        for (int i = 0; i < TEXT.length(); i++) {
            char c = TEXT.charAt(i);

            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c, i); // "i" is the index of the char. it will be used after the "for" loop
                    break;

                case ')':
                    if (stack.tos > -1) {
                        if (stack.stck[stack.tos] == '(') { // checking the matching of opened and closed types for braces
                            stack.pop();
                        } else {
                            System.out.println("Error: Opened \'" + stack.stck[stack.tos] + "\' but closed \'" + c + "\' in index " + i);
                            stack.pop();
                        }
                    } else { // this else will work if in the stack there isn't any opened brace
                        System.out.println("Error: There is missing brace for \'" + c + "\' in index " + i + " or it is extra");
                    }
                    break;

                case ']':
                    if (stack.tos > -1) {
                        if (stack.stck[stack.tos] == '[') { // checking the matching of opened and closed types for braces
                            stack.pop();
                        } else {
                            System.out.println("Error: Opened \'" + stack.stck[stack.tos] + "\' but closed \'" + c + "\' in index " + i);
                            stack.pop();
                        }
                    } else { // this else will work if in the stack there isn't any opened brace
                        System.out.println("Error: There is missing brace for \'" + c + "\' in index " + i + " or it is extra");
                    }
                    break;

                case '}':
                    if (stack.tos > -1) {
                        if (stack.stck[stack.tos] == '{') { // checking the matching of opened and closed types for braces
                            stack.pop();
                        } else {
                            System.out.println("Error: Opened \'" + stack.stck[stack.tos] + "\' but closed \'" + c + "\' in index " + i);
                            stack.pop();
                        }
                    } else { // this else will work if in the stack there isn't any opened brace
                        System.out.println("Error: There is missing brace for \'" + c + "\' in index " + i + " or it is extra");
                    }
                    break;
            }
        }
        /* after checking al the characters in the text we need to be sure
        we didn't leave any opened brace. If so, show the type of the brace
        and its position
        */
        if (stack.tos > -1) {
            for (int i = stack.tos; i >= 0; i--) {
                char braceType = TEXT.charAt(stack.intStck[i]);
                int bracePosition = stack.intStck[i];
                System.out.println("Brace \'" + braceType + "\' was opened in index " + bracePosition + " but never closed");
            }
        }
    }
}
