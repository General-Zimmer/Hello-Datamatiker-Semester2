package obligotorisk_opgave.opg4_semafor;

import obligotorisk_opgave.common_utils.models.Faelles;
import obligotorisk_opgave.opg4_semafor.threads.Taeller;

import java.util.concurrent.Semaphore;

public class MainSemafor {
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Thread thread1 = new Taeller(faelles, "Thread 1", semaphore);
        Thread thread2 = new Taeller(faelles, "Thread 2", semaphore);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(faelles.getCounter());
    }
}
