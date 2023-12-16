package org.example;

import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new ThrowExceptionsTask(), 0, 60000);
        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThrowExceptionsTask extends TimerTask {
        @Override
        public void run() {

            RunMethods runMethods = new RunMethods();

            runMethods.databaseMethod();
            runMethods.runtimeMethod();
            runMethods.ioMethod();
            runMethods.warnMethod();
        }


    }

}
