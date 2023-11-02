package homework.onlineshop.model;

import homework.onlineshop.enums.ProductType;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stockQty; // quantity of the product
    private ProductType productType;

    public Product(String id, String name, double price, int stockQty, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQty = stockQty;
        this.productType = productType;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                ", Stock Quantity=" + stockQty +
                ", Product Type=" + productType.name() +
                '}';
    }
}
