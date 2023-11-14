package opgaver.opg2semafor;

public class Tjener extends Thread {

    private final Resturant resturant;
    public Tjener(Resturant resturant) {
        this.resturant = resturant;
    }

    @Override
    public void run() {

        while (true) {
            int bestillingsnr;
            try {
                resturant.getTjenerLock().acquire();
                bestillingsnr = resturant.bestil();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                resturant.getTjenerLock().release();
            }

            System.out.println("Tjeneren har taget bestilling nr. " + bestillingsnr);

        }
    }
}
