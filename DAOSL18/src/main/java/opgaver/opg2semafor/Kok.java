package opgaver.opg2semafor;

public class Kok extends Thread {

    private final Resturant resturant;
    public Kok(Resturant resturant) {
        this.resturant = resturant;
    }
    @Override
    public void run() {

        while (true) {
            try {
                resturant.getKokLock().acquire();
                if (resturant.getCounterBestillinger() > resturant.getCounterMadPotioner()) {
                    int potionnr = resturant.potionFærdig();
                    System.out.println("Kokken har lavet potion " + potionnr);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                resturant.getKokLock().release();
            }


            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
