package obligotorisk_opgave.opg3_monitor.threads;

import obligotorisk_opgave.models.Faelles;

import static obligotorisk_opgave.utils.CommonUtil.printCounter;

public class Taeller extends Thread {

    private final Faelles faelles;
    private final String name;
    public Taeller(Faelles faelles, String name) {
        this.faelles = faelles;
        this.name = name;
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            // Synchronized block using faelles as lock
            synchronized (faelles) {
                faelles.addCount();
            }
            // Waste random time to start addcount at random intervals
            faelles.wasteTime(10000);
        }

        printCounter(name, faelles);

    }
}
