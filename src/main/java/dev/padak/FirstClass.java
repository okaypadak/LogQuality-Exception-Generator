package dev.padak;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class FirstClass {

    private static final String LOG_FILE_NAME = "log.txt";

    public static void main(String[] args) {

        try {
            Timer timer = new Timer();
            timer.schedule(new ThrowExceptionsTask(), 2000, 6000);
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThrowExceptionsTask extends TimerTask {
        @Override
        public void run() {

            NoTryCatchMetod noTryCatchMetod = new NoTryCatchMetod();
            TryCatchMetod tryCatchMetod = new TryCatchMetod();

            //noTryCatchMetod.databaseMethod();
            //noTryCatchMetod.runtimeMethod();
            //noTryCatchMetod.ioMethod();
            //noTryCatchMetod.warnMethod();
            //noTryCatchMetod.mathMethod();*

            tryCatchMetod.databaseMethod();
            tryCatchMetod.runtimeMethod();
            tryCatchMetod.ioMethod();
            tryCatchMetod.warnMethod();

            try {
                tryCatchMetod.nestedMethod();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                tryCatchMetod.mathMethod();
            } catch (Exception e) {
                logException(e, "WARN");

            }

        }

    }

    private static void logException(Exception e, String logLevel) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_NAME, true))) {
            writer.println(logLevel + " - Exception: " + e.getMessage());
            e.printStackTrace(writer);
            System.out.println(logLevel + " - Exception logged: " + e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class SubClass {
    public void other() throws SQLException {
        System.out.printf("This is a test metod");
        throw new SQLException("Sub metodta SQL exception fırlatıldı!");
    }


}
