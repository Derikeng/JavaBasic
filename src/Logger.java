

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Logger {
    private static Logger logger;

    enum logLevel {
        DEBUG,
        INFO,
        WARN,
        ERROR,
        FATAL
    }

    private Logger() {

    }

    private void listLog(String message, logLevel level) {
        try (FileWriter fileWriter = new FileWriter("D:\\IT\\projects\\javaBasic\\src\\HomeWork13\\LogFile", true)) {
            LocalDateTime date = LocalDateTime.now();
            fileWriter.write(level + " " + " " + date + " " + message + "\n ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void debug(String message) {
        listLog(message, logLevel.DEBUG);
    }

    public void info(String message) {
        listLog(message, logLevel.INFO);
    }

    public void warn(String message) {
        listLog(message, logLevel.WARN);
    }

    public void error(String message) {
        listLog(message, logLevel.ERROR);
    }

    public void fatal(String message) {
        listLog(message, logLevel.FATAL);
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
