package opgaver.opg3javasync;

public class Kok extends Thread {

    private final Resturant resturant;
    public Kok(Resturant resturant) {
        this.resturant = resturant;
    }
    @Override
    public void run() {

        while (true) {

            try {
                int potionnr = resturant.potionFærdig();
                System.out.println("Kokken har lavet potion " + potionnr);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
