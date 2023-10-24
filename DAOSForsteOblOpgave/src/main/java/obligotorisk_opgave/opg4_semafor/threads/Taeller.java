package obligotorisk_opgave.opg4_semafor.threads;

import obligotorisk_opgave.common_utils.CommonUtil;

import java.util.concurrent.Semaphore;

public class Taeller extends Thread {

    int[] counter;
    String name;
    private Semaphore semaphore;
    public Taeller(int[] counter, String name, Semaphore semaphore) {
        this.counter = counter;
        this.name = name;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            try {
                semaphore.acquire();
                counter[0]++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
            CommonUtil.wasteTime(1000);
        }

        System.out.println(name + " finished with " + counter[0]);

    }
}
