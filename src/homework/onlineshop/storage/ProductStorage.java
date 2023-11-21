package homework.onlineshop.storage;

import homework.onlineshop.model.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductStorage implements Serializable {
    private Set<Product> products = new HashSet<>();

    public void add(Product product) {
        products.add(product);
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (Product product : products) {
            System.out.println(product);
        }
    }


    public Product getById(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void deleteById(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                products.remove(product);
                StorageSerializeUtil.serializeProductStorage(this);
                System.out.println("Product with \'" + productId + "\' was deleted!!!");
                return;
            }
        }
        System.out.println("Product does not exist!");
    }

    public Product[] getAllProducts() {
        return products.toArray(new Product[0]);
    }

    public void printAllProducts() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println();
    }
}
