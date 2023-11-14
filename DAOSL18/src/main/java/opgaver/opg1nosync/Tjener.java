package opgaver.opg1nosync;

public class Tjener extends Thread {

    private final Resturant resturant;
    public Tjener(Resturant resturant) {
        this.resturant = resturant;
    }

    @Override
    public void run() {

        while (true) {
            int bestillingsnr = resturant.bestil();
            System.out.println("Tjeneren har taget bestilling nr. " + bestillingsnr);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
