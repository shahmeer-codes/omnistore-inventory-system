import model.*;
import service.*;
import util.*;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Logger.log("SYSTEM", "Initializing OmniStore Engine...");

        InventoryManager inventory = new InventoryManager();

        inventory.addProduct(new ElectronicsProduct("P101", "Wireless Laptop Mouse", 29.99, 10, 12));
        inventory.addProduct(new GroceryProduct("P102", "Organic Almond Milk", 4.50, 20, "2026-12-31"));

        inventory.displayInventory();

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Logger.log("TIMER", "Running automated background inventory audit...");
            }
        }, 1000, 5000);

        Order order1 = new Order("ORD-001", "P101", 3);
        Order order2 = new Order("ORD-002", "P102", 25);
        Order order3 = new Order("ORD-003", "P101", 2);

        Thread t1 = new Thread(new OrderProcessor(order1, inventory));
        Thread t2 = new Thread(new OrderProcessor(order2, inventory));
        Thread t3 = new Thread(new OrderProcessor(order3, inventory));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Logger.log("ERROR", "Main thread execution interrupted.");
        }

        inventory.displayInventory();
        Logger.log("SYSTEM", "All transactions processed. Logs saved to audit_log.txt.");
        timer.cancel();
    }
    }
