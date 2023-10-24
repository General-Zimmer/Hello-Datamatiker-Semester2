package obligotorisk_opgave.opg1_nosync;

import obligotorisk_opgave.common_utils.models.Faelles;
import obligotorisk_opgave.opg1_nosync.threads.Taeller;

public class MainNosync {

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
