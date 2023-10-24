package obligotorisk_opgave.opg3_monitor;

import obligotorisk_opgave.opg3_monitor.threads.Taeller;

public class MainMonitor {

    private static int[] counter = new int[1];

    public static void main(String[] args) {
        Thread thread1 = new Taeller(counter, "Thread 1");
        Thread thread2 = new Taeller(counter, "Thread 2");

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
