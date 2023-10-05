package classwork.library;

import java.util.Scanner;

public class LibraryMain {
    static Scanner scanner = new Scanner(System.in);
    static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) {


        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();

            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addBook();
                    break;
                case "2":
                    searchBook();
                    break;
                case "3":
                    printAllBooks();
                    break;
                default:
                    System.out.println("Invalid command. Try again!\n");
            }
        }
    }

    private static void printAllBooks() {
        System.out.println("--------------");
        bookStorage.print();
        System.out.println("--------------");
    }

    private static void searchBook() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.search(keyword);
    }

    private static void addBook() {
        System.out.println("Please input book title");
        String title = scanner.nextLine();
        System.out.println("Please input author name");
        String authorName = scanner.nextLine();
        System.out.println("Please input price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input count");
        int count = Integer.parseInt(scanner.nextLine());
        Book book = new Book(title, authorName, price, count);
        bookStorage.add(book);
        System.out.println("The book is created!");
    }

    private static void printCommands() {
        System.out.println("Please input 0 to EXIT");
        System.out.println("Please input 1 to ADD BOOK");
        System.out.println("Please input 2 to SEARCH BOOK");
        System.out.println("Please input 3 to TO PRINT ALL BOOKS");
    }
}
