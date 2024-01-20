package dev.padak;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class NoTryCatchMetod {

    public void databaseMethod() throws SQLException {

        throw new SQLException("Dakikada bir SQL exception fırlatıldı!");

    }

    public void mathMethod() {
        int sonuc = 5 / 0;
    }

    public void runtimeMethodNoTry() {
        throw new RuntimeException("No try Dakikada bir runtime exception fırlatıldı!");
    }


    public void runtimeMethod() {

        throw new RuntimeException("Dakikada bir runtime exception fırlatıldı!");

    }

    public void ioMethod() throws IOException {

        throw new IOException("Dakikada bir IO exception fırlatıldı!");

    }

    public void warnMethod() {

        throw new UnsupportedOperationException("Dakikada bir uyarı (warn) fırlatıldı!");
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
