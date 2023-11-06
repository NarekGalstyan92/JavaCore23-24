package homework.onlineshop.storage;

import homework.onlineshop.model.Product;

import java.io.Serializable;

public class ProductStorage implements Serializable {
    private Product[] products = new Product[10];
    private int size;

    public void add(Product user) {
        if (size == products.length) {
            extend();
        }
        products[size++] = user;
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }

    private void extend() {
        Product[] tmp = new Product[products.length + 10];
        System.arraycopy(products, 0, tmp, 0, products.length);
        products = tmp;
    }

    public Product getById(String productId) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId)) {
                return products[i];
            }
        }
        return null;
    }

    public void deleteById(String productId) {
        int indexById = getIndexById(productId);
        if (indexById == -1) {
            System.out.println("Product does not exists!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            products[i - 1] = products[i];
        }
        size--;
        StorageSerializeUtil.serializeProductStorage(this);
        System.out.println("Product with \'" + productId + "\' was deleted!!!");
    }

    private int getIndexById(String productId) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public Product[] getProductsByOrderId(String orderId) {
        Product[] productsByOrder = new Product[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                productsByOrder[j] = products[i];
                j++;
            }
        }
        if (productsByOrder[0] != null) {
            return productsByOrder;
        }
        return null;
    }

    public Product[] getAllProducts() {
        return products;
    }

    public void printAllProducts() {
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
        }
        System.out.println();
    }
}
