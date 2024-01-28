package dev.padak;

public class InsideClass {

    public void insideMetod() throws Exception {

      try {
            System.out.println("insideMetod step 1");


            try {
                System.out.println("insideMetod step 2");
                throw new Exception("insideMetod tekrar throw firlatildi");

            } catch (Exception e) {
                System.out.println("insideMetod step 3");
                throw new Exception("insideMetod Tekrar throw firlatildi");
            }

        } catch (Exception e) {
            System.out.println("insideMetod step 4");
            throw new Exception("insideMetod Tekrar throw firlatildi");
        }

    }
}
