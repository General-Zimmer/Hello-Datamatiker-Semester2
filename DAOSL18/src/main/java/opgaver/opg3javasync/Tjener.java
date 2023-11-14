package opgaver.opg3javasync;

public class Tjener extends Thread {

    private final Resturant resturant;
    public Tjener(Resturant resturant) {
        this.resturant = resturant;
    }

    @Override
    public void run() {

        while (true) {

            try {
                int bestillingsnr = resturant.bestil();
                System.out.println("Tjeneren har taget bestilling nr. " + bestillingsnr);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
