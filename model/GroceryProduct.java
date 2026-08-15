
package model;

public class GroceryProduct extends AbstractProduct {
    private String expiryDate;

    public GroceryProduct(String id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; 
    }

    public String getExpiryDate() { return expiryDate; }
}
