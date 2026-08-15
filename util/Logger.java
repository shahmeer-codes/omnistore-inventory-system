
package util;

import java.util.Date;

public class Logger {
    public static void log(String level, String... messages) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(new Date()).append("] [").append(level).append("]: ");
        for (String msg : messages) {
            sb.append(msg).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
