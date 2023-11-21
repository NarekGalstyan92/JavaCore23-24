package homework.onlineshop.storage;

import homework.onlineshop.model.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderStorage implements Serializable {
    private List<Order> orders = new LinkedList<>();

    public void add(Order order) {
        orders.add(order);
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void print() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public Order getById(String orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                return order;
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
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getId().equals(orderId)) {
                orders.remove(i);
                System.out.println("Order with \'" + orderId + "\' was deleted!!!");
                StorageSerializeUtil.serializeOrderStorage(this);
                return;
            }
        }
    }

    public Order[] getOrdersByOrderId(String orderId) {
        List<Order> ordersByOrderId = new ArrayList<>();
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                ordersByOrderId.add(order);
            }
        }
        if (!ordersByOrderId.isEmpty()) {
            return ordersByOrderId.toArray(new Order[0]);
        }
        return null;
    }

    public Order getOrderByOrderId(String id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId().equals(id)) {
                return orders.get(i);
            }
        }
        return null;
    }

    public Order[] getOrdersByUserId(String id) {
        Order[] ordersByUserId = new Order[orders.size()];
        int j = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUser().getId().equals(id)) {
                ordersByUserId[j] = orders.get(i);
                j++;
            }
        }
        if (ordersByUserId.length >= 1) {
            return ordersByUserId;
        }
        return null;
    }

    private int getIndexById(String orderId) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId().equals(orderId)) {
                return i;
            }
        }
        return -1;
    }
}
