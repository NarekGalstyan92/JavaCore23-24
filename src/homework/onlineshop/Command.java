package homework.onlineshop;

public interface Command {

    String LOGIN = "0";
    String REGISTER = "1";
    String EXIT = "9";
    String LOG_OUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "7";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS = "6";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";

    int YES = 1;
    int NO = 2;

    static void printWelcomeCommands() {
        System.out.println("Welcome to online shop \"Big Square\"");
        System.out.println("Please enter " + LOGIN + " to Log In");
        System.out.println("Please enter " + REGISTER + " to Register");
        System.out.println("Please enter " + EXIT + " to Exit the program");
    }

    static void printUserCommands() {
        System.out.println("Please enter " + LOG_OUT + " to LOG OUT FROM SYSTEM");
        System.out.println("Please enter " + PRINT_PRODUCTS + " to PRINT ALL PRODUCTS");
        System.out.println("Please enter " + BUY_PRODUCT + " to BUY PRODUCT");
        System.out.println("Please enter " + PRINT_MY_ORDERS + " to PRINT MY ORDERS");
        System.out.println("Please enter " + CANCEL_ORDER_BY_ID + " to CANCEL ORDER BY ID");
    }

    static void printAdminCommands() {
        System.out.println("Please enter " + LOG_OUT + " to LOG OUT FROM SYSTEM");
        System.out.println("Please enter " + ADD_PRODUCT + " to ADD PRODUCT");
        System.out.println("Please enter " + REMOVE_PRODUCT_BY_ID + " to REMOVE PRODUCT BY ID");
        System.out.println("Please enter " + PRINT_USERS + " to PRINT USERS");
        System.out.println("Please enter " + PRINT_ORDERS + " to PRINT ORDERS");
        System.out.println("Please enter " + CHANGE_ORDER_STATUS + " to CHANGE ORDER STATUS");
        System.out.println("Please enter " + PRINT_PRODUCTS + " to PRINT ALL PRODUCTS");
    }
}
