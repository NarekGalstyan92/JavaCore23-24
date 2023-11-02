package homework.onlineshop.storage;

import homework.onlineshop.model.Order;

public class OrderStorage {
    private Order[] orders = new Order[10];
    private int size;

    public void add(Order order) {
        if (size == orders.length) {
            extend();
        }
        orders[size++] = order;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }

    public Order getById(String orderId) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId)) {
                return orders[i];
            }
        }
        return null;
    }

    public void deleteById(String orderId) {
        int indexById = getIndexById(orderId);
        if (indexById == -1) {
            System.out.println("Order does not exists!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            orders[i - 1] = orders[i];
        }
        size--;
    }

    public Order[] getOrdersByOrderId(String orderId) {
        Order[] ordersByUserId = new Order[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (orders[i] != null) {
                ordersByUserId[j] = orders[i];
                j++;
            }
        }
        if (ordersByUserId[0] != null) {
            return ordersByUserId;
        }
        return null;
    }

    public Order getOrderByOrderId(String id) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(id)) {
                return orders[i];
            }
        }
        return null;
    }

    public Order[] getOrdersByUserId(String id) {
        Order[] ordersByUserId = new Order[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().getId().equals(id)) {
                ordersByUserId[j] = orders[i];
                j++;
            }
        }
        if (ordersByUserId.length >= 1) {
            return ordersByUserId;
        }
        return null;
    }

    private int getIndexById(String orderId) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId)) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        Order[] tmp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }

}
