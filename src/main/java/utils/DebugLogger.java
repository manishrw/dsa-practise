package utils;

import java.time.LocalTime;

import static java.lang.System.out;

public class DebugLogger{
    private boolean flag;

    public DebugLogger() {
        this.flag = true;
    }

    public void disable() {
        this.flag = false;
    }

    public void enable() {
        this.flag = true;
    }

    public void log(String message, Object... args) {
        if (!flag) return;
        var finalMessage = String.format(LocalTime.now().toString() + ": " + message + "%n", args);
        out.printf(finalMessage, args);
    }

    public static synchronized DebugLogger getInstance() {
        return new DebugLogger();
    }
}
