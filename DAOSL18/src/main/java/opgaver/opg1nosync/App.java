package opgaver.opg1nosync;

public class App {
    public static void main(String[] args) {
        Resturant resturant = new Resturant();
        Kok kok = new Kok(resturant);
        Tjener tjener1 = new Tjener(resturant);
        Tjener tjener2 = new Tjener(resturant);
        kok.start();
        tjener1.start();
        tjener2.start();

        try {
            kok.join();
            tjener1.join();
            tjener2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Der er ikke flere kunder");
    }
}
