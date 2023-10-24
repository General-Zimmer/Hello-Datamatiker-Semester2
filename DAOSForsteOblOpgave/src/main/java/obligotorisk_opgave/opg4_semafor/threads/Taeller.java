package obligotorisk_opgave.opg4_semafor.threads;

import obligotorisk_opgave.models.Faelles;

import java.util.concurrent.Semaphore;

import static obligotorisk_opgave.utils.CommonUtil.printCounter;

public class Taeller extends Thread {

    private final Faelles faelles;
    private final String name;
    private final Semaphore semaphore;
    public Taeller(Faelles faelles, String name, Semaphore semaphore) {
        this.faelles = faelles;
        this.name = name;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            try {
                semaphore.acquire();
                faelles.addCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
            // Waste random time to start addcount at random intervals
            faelles.wasteTime(10000);
        }

        printCounter(name, faelles);

    }
}
