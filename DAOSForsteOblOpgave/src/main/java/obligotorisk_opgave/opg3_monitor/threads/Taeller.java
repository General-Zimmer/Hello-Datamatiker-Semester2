package obligotorisk_opgave.opg3_monitor.threads;

import obligotorisk_opgave.common_utils.CommonUtil;

public class Taeller extends Thread {

    int[] counter;
    String name;
    public Taeller(int[] counter, String name) {
        this.counter = counter;
        this.name = name;
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            // 1. Synchronized block
            synchronized (counter) {
                counter[0]++;
            }

            CommonUtil.wasteTime(1000);
        }

        System.out.println(name + " finished with " + counter[0]);

    }
}
