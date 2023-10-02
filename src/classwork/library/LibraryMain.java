package classwork.library;

import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookStorage bookStorage = new BookStorage();
        boolean isRun = true;
        while (isRun) {
            System.out.println("Please input 0 to EXIT");
            System.out.println("Please input 1 to ADD BOOK");
            System.out.println("Please input 2 to SEARCH BOOK");
            System.out.println("Please input 3 to TO PRINT ALL BOOKS");
            String command = scanner.nextLine();

            switch (command){
                case "0":
                    isRun = false;
                    break;
                case "1":
                    System.out.println("Please input book title");
                    String title = scanner.nextLine();
                    System.out.println("Please input author name");
                    String authorName = scanner.nextLine();
                    System.out.println("Please input price");
                    double price= Double.parseDouble(scanner.nextLine());
                    System.out.println("Please input count");
                    int count = Integer.parseInt(scanner.nextLine());
                    Book book = new Book(title, authorName, price, count);
                    bookStorage.add(book);
                    System.out.println("The book is created!");
                    break;
                case "2":
                    System.out.println("Please input keyword");
                    String keyword = scanner.nextLine();
                    bookStorage.search(keyword);
                    break;
                case "3":
                    System.out.println("--------------");
                    bookStorage.print();
                    System.out.println("--------------");
                    break;
                default:
                    System.out.println("Invalid command. Try again!\n");
            }
        }
    }
}
