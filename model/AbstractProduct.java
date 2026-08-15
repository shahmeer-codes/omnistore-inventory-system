package model;

public abstract class AbstractProduct {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public AbstractProduct(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTax();

    @Override
    public String toString() {
        return String.format("[%s] %s | Price: $%.2f | Stock: %d", id, name, price, quantity);
    }
}
