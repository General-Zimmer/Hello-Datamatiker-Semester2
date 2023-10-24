package obligotorisk_opgave.opg1_nosync.threads;

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
            // Do da thing
            faelles.addCount();
            // Waste random time to start addcount at random intervals
            faelles.wasteTime(10000);
        }

        printCounter(name, faelles);
    }
}
