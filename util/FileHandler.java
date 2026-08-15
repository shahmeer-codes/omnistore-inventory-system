package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
    private static final String FILE_PATH = "audit_log.txt";

    public static synchronized void appendLog(String logEntry) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(logEntry);
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}
