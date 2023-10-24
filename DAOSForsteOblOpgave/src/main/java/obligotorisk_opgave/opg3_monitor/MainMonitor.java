package obligotorisk_opgave.opg3_monitor;

import obligotorisk_opgave.common_utils.models.Faelles;
import obligotorisk_opgave.opg3_monitor.threads.Taeller;

public class MainMonitor {


    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Thread thread1 = new Taeller(faelles, "Thread 1");
        Thread thread2 = new Taeller(faelles, "Thread 2");

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
