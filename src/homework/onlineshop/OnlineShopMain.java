package homework.onlineshop;

import homework.onlineshop.enums.OrderStatus;
import homework.onlineshop.enums.PaymentMethod;
import homework.onlineshop.enums.ProductType;
import homework.onlineshop.enums.UserType;
import homework.onlineshop.exception.OutOfStockException;
import homework.onlineshop.model.Order;
import homework.onlineshop.model.Product;
import homework.onlineshop.model.User;
import homework.onlineshop.storage.OrderStorage;
import homework.onlineshop.storage.ProductStorage;
import homework.onlineshop.storage.UserStorage;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class OnlineShopMain implements Command {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductStorage productStorage = new ProductStorage();
    private static UserStorage userStorage = new UserStorage();
    private static OrderStorage orderStorage = new OrderStorage();
    private static User currentUser = null;
    private static final String dashes = "-".repeat(20);


    public static void main(String[] args) {

        // a ready block of code with data to test the program
        {
            String userType1 = "ADMIN";
            String userType2 = "USER";
            UserType newUserType1 = UserType.valueOf(userType1.toUpperCase());
            UserType newUserType2 = UserType.valueOf(userType2.toUpperCase());
            User user1 = new User("U1234", "Narek", "Galstyan", "narek@gmail.com", "1234", newUserType1);
            User user2 = new User("U2345", "Poxos", "Poxosyan", "poxos@gmail.com", "4321", newUserType2);
            userStorage.add(user1);
            userStorage.add(user2);
            Product product1 = new Product("asdf12", "E-cigarette", 20.0, 15, ProductType.ELECTRONICS);
            Product product2 = new Product("fdsa12", "Harry Potter", 14.0, 5, ProductType.BOOKS);
            productStorage.add(product1);
            productStorage.add(product2);
            Order order1 = new Order("order123", user1, product1, new Date(), 100, OrderStatus.NEW, 5, PaymentMethod.CARD);
            Order order2 = new Order("order321", user2, product2, new Date(), 50, OrderStatus.NEW, 5, PaymentMethod.CASH);
            orderStorage.add(order1);
            orderStorage.add(order2);
        }

        boolean run = true;
        while (run) {
            Command.printWelcomeCommands();
            String welcomeCommand = scanner.nextLine();
            switch (welcomeCommand) {
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    try {
                        registerUser();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid user type. Please enter either USER or ADMIN.");
                    }
                    break;
                case EXIT:
                    System.out.println("See you soon");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void login() {
        System.out.println("Please enter email");
        String email = scanner.nextLine();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        boolean checkedCredentials = checkCredentials(email, password);
        boolean loggedIn = true;
        if (!checkedCredentials) {
            System.out.println("Bad Credentials");
        } else if (userStorage.getUserTypeByEmail(email).equals(UserType.USER)) { // this "else-if" will work if simple user is logged in
            currentUser = userStorage.getByEmail(email);
            while (loggedIn) {
                Command.printUserCommands();
                String input = scanner.nextLine();
                switch (input) {
                    case LOG_OUT:
                        System.out.println("See you soon " + currentUser.getName() + "!\n");
                        loggedIn = false;
                        break;
                    case PRINT_PRODUCTS:
                        printAllProducts();
                        break;
                    case BUY_PRODUCT:
                        try {
                            buyProduct();
                        } catch (OutOfStockException e) {
                            System.out.printf(e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Something went wrong either with the price or the quantity\n");
                        } catch (IllegalArgumentException | ParseException e) {
                            System.out.println("Failed to put an order because of the wrong payment method\n");
                        }
                        break;
                    case PRINT_MY_ORDERS:
                        printUserOrders();
                        break;
                    case CANCEL_ORDER_BY_ID:
                        cancelOrderById();
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            }
        } else if (userStorage.getUserTypeByEmail(email).equals(UserType.ADMIN)) { // this "else-if" statement will work if admin is logged in
            currentUser = userStorage.getByEmail(email);
            while (loggedIn) {
                Command.printAdminCommands();
                String input = scanner.nextLine();
                switch (input) {
                    case LOG_OUT:
                        System.out.println("See you soon " + currentUser.getName() + "!\n");
                        loggedIn = false;
                        break;
                    case ADD_PRODUCT:
                        try {
                            addProduct();
                        } catch (NumberFormatException e) {
                            System.out.println("Something went wrong with price or quantity");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Wrong product type");
                        }
                        break;
                    case REMOVE_PRODUCT_BY_ID:
                        removeProductById();
                        break;
                    case PRINT_USERS:
                        printAllUsers();
                        break;
                    case PRINT_ORDERS:
                        printAllOrders();
                        break;
                    case CHANGE_ORDER_STATUS:
                        try {
                            changeOrderStatus();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Wrong order type");
                        }
                        break;
                    case PRINT_PRODUCTS:
                        productStorage.printAllProducts();
                        break;
                    default:
                        System.out.println("Wrong command");
                        break;
                }
            }
        }
    }

    private static void changeOrderStatus() throws IllegalArgumentException { // this method could be written either through user or directly wit order id
        System.out.println("Please enter order id");
        orderStorage.print();
        String orderById = scanner.nextLine();
        Order orderByOrderId = orderStorage.getOrderByOrderId(orderById);
        if (orderByOrderId != null) {
            System.out.println("Please enter new status for order");
            System.out.println(Arrays.toString(OrderStatus.values()));
            OrderStatus newStatus = OrderStatus.valueOf(scanner.nextLine().toUpperCase()); // IllegalArgumentException will be thrown because of this line
            orderByOrderId.setOrderStatus(newStatus); // changing the order status
            System.out.println("Status changed to " + newStatus);
            System.out.println(orderByOrderId);
            System.out.println();
        } else {
            System.out.println("Order not found!");
        }

    }

    private static void printAllOrders() {
        orderStorage.print();
    }

    private static void printAllUsers() {
        userStorage.print();
    }

    private static void removeProductById() {
        System.out.println("Please input product id from the list bellow");
        productStorage.printAllProducts();
        String productId = scanner.nextLine();
        Product byId = productStorage.getById(productId); // product from productStorage can be null, so we will check this case
        if (byId != null) {
            productStorage.deleteById(productId);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found");
        }
    }

    private static void addProduct() throws IllegalArgumentException {
        UUID fullUuid = UUID.randomUUID();
        String uuidString = fullUuid.toString();
        String uuid = uuidString.substring(0, 6); // Extract the first 6 characters from the UUID string. This string will be the product id
        System.out.println("Please enter product name");
        String productName = scanner.nextLine();
        System.out.println("Please enter the price");
        // bellow Double.parseDouble() method can throw unchecked NumberFormatException,
        // which inherits from IllegalArgumentException.
        // The ProductType.values() method also throws IllegalArgumentException.
        // That's why in exception handling process it is unclear which method is the cause
        // of the exception. it is handled in general form.
        double price = Double.parseDouble(scanner.nextLine());
        if (price >= 0 && price < Integer.MAX_VALUE) {
            System.out.println("Please enter the quantity");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity > 0) {
                System.out.println("Please enter product type/category");
                String productTypeStr = scanner.nextLine().toUpperCase(); // as the enums are final, the productTypeStr should always be upper case
                ProductType productType = ProductType.valueOf(productTypeStr); // converting inputted productTypeStr to productType
                for (int i = 0; i < ProductType.values().length; i++) {
                    if (!ProductType.values()[i].equals(productType)) { // checking if there are such product types in enums
                        System.out.println("Product type does not exist");
                    } else {
                        Product product = new Product(uuid, productName, price, quantity, productType);
                        productStorage.add(product);
                        System.out.println("Product created successfully!");
                        System.out.println(product);
                        System.out.println();
                        break;
                    }
                }
            } else {
                System.out.println("Quantity should be greater than 0");
            }
        } else {
            System.out.println("Price should be in range 0.0 and " + Integer.MAX_VALUE + "$");
        }
    }

    private static void cancelOrderById() {
        Order[] ordersByUserId = orderStorage.getOrdersByUserId(currentUser.getId());
        if (ordersByUserId != null) {
            System.out.println("Please enter order id to cancel the order");
            printUserOrders();
            String orderId = scanner.nextLine();
            boolean canceled = false;

            for (Order order : ordersByUserId) {
                if (order.getId().equals(orderId)) { // checkin if we have an order with given id
                    orderStorage.deleteById(orderId);
                    canceled = true;
                    break; // exit the loop once the order is found and canceled
                }
            }

            if (canceled) {
                System.out.println("Order with " + orderId + " id was canceled");
            } else {
                System.out.println("Order with " + orderId + " id does not exist");
            }
        } else {
            System.out.println("You don't have any orders to cancel\n");
        }
    }


    private static void printUserOrders() {
        Order[] ordersByUserId = orderStorage.getOrdersByUserId(currentUser.getId());
        System.out.println(dashes);
        if (ordersByUserId != null) {
            for (Order order : ordersByUserId) {
                if (order != null) {
                    System.out.println(order);
                }
            }
        } else {
            System.out.println("You dont have any orders");
        }
        System.out.println(dashes);
    }

    private static void buyProduct() throws ParseException, OutOfStockException, IllegalArgumentException {
        boolean productExisting = false; // Flag to track if the selected product exists
        boolean purchaseProcessIsRunning = true; // Flag to control the purchase process

        System.out.println("Please chose the product from the list and enter product Id:");
        printAllProducts();
        Product[] allProducts = productStorage.getAllProducts();
        String productId = scanner.nextLine();
        while (purchaseProcessIsRunning) {
            for (Product product : allProducts) {
                if (product != null && product.getId().equals(productId)) {
                    productExisting = true;
                    System.out.println("Please enter the quantity you want to buy");
                    String quantityStr = scanner.nextLine();
                    // bellow Integer.parseInt() method can throw unchecked NumberFormatException,
                    // which inherits from IllegalArgumentException.
                    // The PaymentMethod.valueOf() method also throws IllegalArgumentException.
                    // That's why in exception handling process it is unclear which method is the cause
                    // of the exception. it is handled in general form.
                    int quantity = Integer.parseInt(quantityStr);
                    if (quantity > 0 && quantity < product.getStockQty()) { // Check if the entered quantity is valid
                        System.out.println("Please enter payment method:");
                        System.out.println(Arrays.toString(PaymentMethod.values()));
                        PaymentMethod paymentMethod = PaymentMethod.valueOf(scanner.nextLine().toUpperCase()); // getting payment method from scanner
                        double totalPrice = quantity * product.getPrice();
                        System.out.println("Your total is: " + totalPrice + " $ for " + quantity + " " + product.getName());
                        boolean decisionIsRunning = true; // Flag to control decision process
                        while (decisionIsRunning) {
                            System.out.println("Would you like to continue the purchase process?");
                            System.out.println("Enter 1 for YES, and 2 for NO");
                            String decisionStr = scanner.nextLine();
                            int decision = Integer.parseInt(decisionStr);
                            switch (decision) {
                                case YES: // Create an order and add it to the order storage
                                    Order order = new Order(productId, currentUser, product, new Date(), totalPrice, OrderStatus.NEW, quantity, paymentMethod);
                                    orderStorage.add(order);
                                    System.out.println("Purchase succeed. Order is in progress\n");
                                    decisionIsRunning = false;
                                    purchaseProcessIsRunning = false;
                                    break;
                                case NO:
                                    decisionIsRunning = false;
                                    purchaseProcessIsRunning = false;
                                    break;
                                default:
                                    System.out.println("Wrong input! Try again");
                            }
                        }
                    } else if (quantity < 0) {
                        System.out.println("Product quantity should be 1 or more");
                    } else
                        throw new OutOfStockException("Requested product quantity is greater than in stock\n");  // Throw an exception if the requested quantity is greater than what's in stock
                }
            }
            if (!productExisting) {
                System.out.println("Product with " + productId + " id does not found");
                purchaseProcessIsRunning = false;
            }
        }
    }

    private static void printAllProducts() {
        Product[] products = checkProductExisting(productStorage.getAllProducts());
        System.out.println(dashes);
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println(dashes);
    }

    private static Product[] checkProductExisting(Product[] products) {
        if (products.length > 0) {
            return products;
        }
        return null;
    }

    private static boolean checkCredentials(String email, String password) {
        User[] usersByEmail = userStorage.getUsersByEmail(email);
        for (User user : usersByEmail) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static void registerUser() throws IllegalArgumentException {
        System.out.println("Please follow the instructions bellow");
        System.out.println("Please enter the user name");
        String username = scanner.nextLine();
        System.out.println("Please enter the user surname");
        String userSurname = scanner.nextLine();
        System.out.println("Please enter the user email");
        String userEmail = scanner.nextLine();
        System.out.println("Please enter the user password");
        String userPassword = scanner.nextLine();
        System.out.println("Please enter the user type (USER or ADMIN)");
        String userType = scanner.nextLine();
        UserType newUserType = UserType.valueOf(userType.toUpperCase()); // UserType.valueOf() method can throw IllegalArgumentException
        System.out.println("Please enter the user id");
        System.out.println("\t to register an admin, start the id with letter A (ex. A1234)");
        System.out.println("\t to register a user, start the id with letter U (ex. U1234)");
        String userId = scanner.nextLine();
        User user = new User(userId, username, userSurname, userEmail, userPassword, newUserType);
        userStorage.add(user);
        System.out.println("User successfully registered");
        System.out.println(user);
    }
}
