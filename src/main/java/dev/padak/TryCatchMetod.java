package dev.padak;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class TryCatchMetod {

    public void databaseMethod() {
        try {
            throw new SQLException("Dakikada bir SQL exception fırlatıldı!");
        } catch (SQLException e) {
            logException(e, "ERROR");
        }
    }

    public void mathMethod() throws Exception {

        try {
            int sonuc = 5 / 0 ;
        } catch (Exception e) {
            logException(e, "ERROR");
            throw new Exception("Tekrar throw firlatildi");
        }
    }

    public void runtimeMethod() {
        try {
            throw new RuntimeException("Dakikada bir runtime exception fırlatıldı!");
        } catch (RuntimeException e) {
            logException(e, "ERROR");
        }
    }

    public void ioMethod() {
        try {
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

    public void nestedMethod() throws Exception {


        Output output = new Output();
        InsideClass insideClass = new InsideClass();

        System.out.println("nestedMethod step 1");
        try {
            insideClass.insideMetod();

            try {
                System.out.println("nestedMethod step 2");
                output.setSonuc("00");
                output.setAciklama("Başarılı");

            } catch (Exception e) {
                System.out.println("nestedMethod step 3");
                throw new Exception("Hata!");
            }

        } catch (Exception e) {
            System.out.println("nestedMethod step 4");
        }



        try {
            System.out.println("nestedMethod step 5");
            output.setSonuc("00");
            output.setAciklama("Başarılı");

        } catch (Exception e) {
            System.out.println("nestedMethod step 6");
            output.setSonuc("DD");
            output.setAciklama("Sunucu hatası yakalandı");

            return;
        }

        System.out.println("nestedMethod step 7");
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
