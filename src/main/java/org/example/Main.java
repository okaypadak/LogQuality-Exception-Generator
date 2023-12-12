package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static final String LOG_FILE_NAME = "log.txt";

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new ThrowExceptionsTask(), 0, 60000); // Dakikada bir çalıştır

        // Uygulamayı çalışır durumda tutmak için ekledik, genellikle gerekmez
        try {
            Thread.sleep(600000); // 10 dakika boyunca çalıştır
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThrowExceptionsTask extends TimerTask {
        @Override
        public void run() {
            try {
                // RuntimeException fırlat
                throw new RuntimeException("Dakikada bir runtime exception fırlatıldı!");
            } catch (RuntimeException e) {
                // RuntimeException'ı log dosyasına ve konsola yaz
                logException(e, "ERROR");
            }

            try {
                // IOException fırlat
                throw new IOException("Dakikada bir IO exception fırlatıldı!");
            } catch (IOException e) {
                // IOException'ı log dosyasına ve konsola yaz
                logException(e, "ERROR");
            }

            try {
                // SQLException fırlat
                throw new SQLException("Dakikada bir SQL exception fırlatıldı!");
            } catch (SQLException e) {
                // SQLException'ı log dosyasına ve konsola yaz
                logException(e, "ERROR");
            }

            try {
                // UnsupportedOperationException ile bir uyarı (warn) fırlat
                throw new UnsupportedOperationException("Dakikada bir uyarı (warn) fırlatıldı!");
            } catch (UnsupportedOperationException e) {
                // Uyarıyı log dosyasına ve konsola yaz
                logException(e, "WARN");
            }
        }

        private void logException(Exception e, String logLevel) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_NAME, true))) {
                // Log dosyasına yaz
                writer.println(logLevel + " - Exception: " + e.getMessage());
                e.printStackTrace(writer);

                // Konsola yaz
                System.out.println(logLevel + " - Exception logged: " + e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
