# OmniStore Inventory & Order Processing System

A comprehensive, thread-safe Core Java application built to demonstrate advanced object-oriented programming, concurrent order processing, and file persistence.

## 🚀 Key Features & Java Concepts Used

- **Object-Oriented Architecture:** Abstract classes (`AbstractProduct`), interfaces, method overriding, and runtime polymorphism.
- **Data Structures:** `HashMap` for fast O(1) inventory lookups and `ArrayList` for batch transaction logging.
- **Multithreading & Timers:** Background threads for asynchronous order processing and `TimerTask` scheduled inventory restocking alerts.
- **Generics & Varargs:** Generic wrapper `Response<T>` for standardized return types and varargs logging utility methods.
- **Robust Exception Handling:** Custom exceptions (`InsufficientStockException`, `ProductNotFoundException`) with `try-catch-finally` blocks.
- **Persistence:** File I/O streaming to record audit logs and transaction history to disk.

## 📁 Repository Overview

- `model/`: Core entities, Enums, and generic containers.
- `exception/`: Domain-specific runtime exceptions.
- `service/`: Thread-safe business logic for stock management and order processing.
- `util/`: File streams, varargs logging, and background timers.
- `Main.java`: Entry point executing inventory operations and multithreaded order workers.

## 💻 How to Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/shahmeer-codes/omnistore-inventory-system.git](https://github.com/shahmeer-codes/omnistore-inventory-system.git)
   cd omnistore-inventory-system
