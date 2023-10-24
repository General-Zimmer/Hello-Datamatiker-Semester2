package obligotorisk_opgave.opg1_nosync.threads;

import obligotorisk_opgave.common_utils.models.Faelles;

public class Taeller extends Thread {

    Faelles faelles;
    String name;
    public Taeller(Faelles faelles, String name) {
        this.faelles = faelles;
        this.name = name;
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            int temp = faelles.getCounter();
            faelles.addCount(yeet -> {
                yeet[0] = temp+1;
            });
        }

        System.out.println(name + " finished with " + faelles.getCounter());

    }
}
