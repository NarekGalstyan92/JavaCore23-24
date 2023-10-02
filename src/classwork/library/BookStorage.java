package classwork.library;

public class BookStorage {

    private Book [] books = new Book[10];
    private int size;
    public void add (Book book) {
        if (size == books.length) {
            extend();
        }
        books[size++] = book;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("Title: " + books[i].getTitle() + ", Author name: " + books[i].getAuthorName() + ", Book price: " + books[i].getPrice() + ", Book count: " + books[i].getCount());
        }
    }

    public void search(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword) || (books[i].getAuthorName().contains(keyword))) {
                System.out.println("Title: " + books[i].getTitle() + " Author name: " + books[i].getAuthorName() + " Book price: " + books[i].getPrice() + " Book count: " + books[i].getCount());
            } else {
                System.out.println("Nothing found!");
            }
        }
    }


    private void extend() {
        Book [] tmp = new Book[books.length + 10];
        System.arraycopy(books, 0, tmp, 0, books.length);
        books = tmp;
    }
}
