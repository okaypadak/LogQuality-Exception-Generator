package org.example;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) {

        try {
            Timer timer = new Timer();
            timer.schedule(new ThrowExceptionsTask(), 500, 60000);
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThrowExceptionsTask extends TimerTask {
        @Override
        public void run() {

            try {
                RunMethods runMethods = new RunMethods();

                runMethods.databaseMethod();
                runMethods.runtimeMethod();
                runMethods.ioMethod();
                runMethods.warnMethod();
                runMethods.mathMethod();
                runMethods.mathMethodNoTry();
            } catch (Exception e) {
                System.out.printf("\n");
            }

        }


    }
}

class SubClass {
    public void other() throws SQLException {
        System.out.printf("This is a test metod");
        throw new SQLException("Sub metodta SQL exception fırlatıldı!");
    }


}
