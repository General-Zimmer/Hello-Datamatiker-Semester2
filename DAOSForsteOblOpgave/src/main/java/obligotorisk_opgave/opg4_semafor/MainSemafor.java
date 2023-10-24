package obligotorisk_opgave.opg4_semafor;

import obligotorisk_opgave.opg4_semafor.threads.Taeller;

import java.util.concurrent.Semaphore;

public class MainSemafor {

    private static int[] counter = new int[1];
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Thread thread1 = new Taeller(counter, "Thread 1", semaphore);
        Thread thread2 = new Taeller(counter, "Thread 2", semaphore);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(counter[0]);
    }
}
