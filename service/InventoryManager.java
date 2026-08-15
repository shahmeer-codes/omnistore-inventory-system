package service;

import exception.InsufficientStockException;
import exception.ProductNotFoundException;
import model.AbstractProduct;
import model.Response;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, AbstractProduct> inventory = new HashMap<>();

    public synchronized void addProduct(AbstractProduct product) {
        inventory.put(product.getId(), product);
    }

    public synchronized Response<AbstractProduct> getProduct(String id) throws ProductNotFoundException {
        if (!inventory.containsKey(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found in inventory.");
        }
        return new Response<>(true, "Product retrieved", inventory.get(id));
    }

    public synchronized void deductStock(String id, int quantity) throws ProductNotFoundException, InsufficientStockException {
        Response<AbstractProduct> response = getProduct(id);
        AbstractProduct product = response.getData();

        if (product.getQuantity() < quantity) {
            throw new InsufficientStockException("Insufficient stock for " + product.getName() + ". Available: " + product.getQuantity());
        }

        product.setQuantity(product.getQuantity() - quantity);
    }

    public synchronized void displayInventory() {
        System.out.println("\n========== CURRENT INVENTORY ==========");
        for (AbstractProduct p : inventory.values()) {
            System.out.println(p + " | Tax: $" + String.format("%.2f", p.calculateTax()));
        }
        System.out.println("=======================================\n");
    }
}
