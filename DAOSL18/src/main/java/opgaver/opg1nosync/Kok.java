package opgaver.opg1nosync;

public class Kok extends Thread {

    private final Resturant resturant;
    public Kok(Resturant resturant) {
        this.resturant = resturant;
    }
    @Override
    public void run() {

        while (true) {
            if (resturant.getCounterBestillinger() > resturant.getCounterMadPotioner()) {
                int potionnr = resturant.potionFærdig();
                System.out.println("Kokken har lavet potion " + potionnr);
            }

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
