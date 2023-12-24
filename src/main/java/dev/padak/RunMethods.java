package dev.padak;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RunMethods {

    public void databaseMethod() {
        try {
            throw new SQLException("Dakikada bir SQL exception fırlatıldı!");
        } catch (SQLException e) {
            logException(e, "ERROR");
        }
    }

    public void mathMethodNoTry() {
        int sonuc = 5 / 0 ;
    }

    public void mathMethod() {

        try {
            int sonuc = 5 / 0 ;
        } catch (Exception e) {
            logException(e, "ERROR");
        }
    }

    public void runtimeMethod() {
        try {
            throw new RuntimeException("Dakikada bir runtime exception fırlatıldı!");
        } catch (RuntimeException e) {
            logException(e, "ERROR");
        }
    }

    public void runtimeMethodNoTry() {
        throw new RuntimeException("No try Dakikada bir runtime exception fırlatıldı!");
    }

    public void ioMethod() {
        try {
            // IOException fırlat
            throw new IOException("Dakikada bir IO exception fırlatıldı!");
        } catch (IOException e) {
            logException(e, "ERROR");
        }
    }

    public void warnMethod(){
        try {
            throw new UnsupportedOperationException("Dakikada bir uyarı (warn) fırlatıldı!");
        } catch (UnsupportedOperationException e) {
            logException(e, "WARN");
        }
    }

    private static final String LOG_FILE_NAME = "log.txt";
    private void logException(Exception e, String logLevel) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_NAME, true))) {
            writer.println(logLevel + " - Exception: " + e.getMessage());
            e.printStackTrace(writer);
            System.out.println(logLevel + " - Exception logged: " + e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
