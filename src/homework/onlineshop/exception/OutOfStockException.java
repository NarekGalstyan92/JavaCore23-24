package homework.onlineshop.exception;

public class OutOfStockException extends Exception {
    private String productName;

    public OutOfStockException(String productName) {
        super("The product is out of stock.\n\n");
        this.productName = productName;
    }

    public OutOfStockException(String message, String productName) {
        super(message);
        this.productName = productName;
    }

    public OutOfStockException(String message, Throwable cause, String productName) {
        super(message, cause);
        this.productName = productName;
    }

    public OutOfStockException(Throwable cause, String productName) {
        super(cause);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "OutOfStockException{}";
    }
}
