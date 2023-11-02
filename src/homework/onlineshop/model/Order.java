package homework.onlineshop.model;

import homework.onlineshop.enums.OrderStatus;
import homework.onlineshop.enums.PaymentMethod;

import java.util.Date;

public class Order {
    private String id;
    private User user;
    private Product product;
    private Date date;
    private double price;
    private OrderStatus orderStatus;
    private int qty; // quantity
    private PaymentMethod paymentMethod;

    public Order(String id, User user, Product product, Date date, double price, OrderStatus orderStatus, int qty, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.date = date;
        this.price = price;
        this.orderStatus = orderStatus;
        this.qty = qty;
        this.paymentMethod = paymentMethod;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id='" + id + '\'' +
                ", User=" + user.getName() + " " + user.getSurname() +
                ", Product=" + product +
                ", Date=" + date +
                ", Price=" + price +
                ", Order Status=" + orderStatus +
                ", Quantity=" + qty +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
