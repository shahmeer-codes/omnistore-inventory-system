
package service;

import exception.InsufficientStockException;
import exception.ProductNotFoundException;
import model.Order;
import model.OrderStatus;
import util.FileHandler;
import util.Logger;

public class OrderProcessor implements Runnable {
    private Order order;
    private InventoryManager inventoryManager;

    public OrderProcessor(Order order, InventoryManager inventoryManager) {
        this.order = order;
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void run() {
        Logger.log("INFO", "Processing Order ID:", order.getOrderId());
        order.setStatus(OrderStatus.PROCESSING);

        try {
            Thread.sleep(1500);

            inventoryManager.deductStock(order.getProductId(), order.getQuantity());
            order.setStatus(OrderStatus.COMPLETED);

            String logMsg = "SUCCESS: Order " + order.getOrderId() + " completed for item " + order.getProductId();
            Logger.log("INFO", logMsg);
            FileHandler.appendLog(logMsg);

        } catch (ProductNotFoundException | InsufficientStockException e) {
            order.setStatus(OrderStatus.FAILED);
            String logMsg = "FAILED: Order " + order.getOrderId() + " - " + e.getMessage();
            Logger.log("ERROR", logMsg);
            FileHandler.appendLog(logMsg);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Logger.log("ERROR", "Order thread interrupted.");
        }
    }
}
