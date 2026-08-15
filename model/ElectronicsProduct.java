
package model;

public class ElectronicsProduct extends AbstractProduct {
    private int warrantyMonths;

    public ElectronicsProduct(String id, String name, double price, int quantity, int warrantyMonths) {
        super(id, name, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15; 
    }

    public int getWarrantyMonths() { return warrantyMonths; }
}
