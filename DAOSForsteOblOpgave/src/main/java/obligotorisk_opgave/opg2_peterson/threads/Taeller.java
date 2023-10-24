package obligotorisk_opgave.opg2_peterson.threads;

import obligotorisk_opgave.common_utils.models.Faelles;
import obligotorisk_opgave.opg2_peterson.MainPeterson;

import static obligotorisk_opgave.common_utils.CommonUtil.printCounter;

public class Taeller extends Thread {

    private final Faelles faelles;
    private final int turn;
    public Taeller(Faelles faelles, int turn) {
        this.faelles = faelles;
        this.turn = turn;
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            // Peterson lock ting tang
            MainPeterson.getFlag()[turn] = true;
            MainPeterson.setTurn(turn);
            // Note: turn == 0 ? 1 : 0 is a ternary operator and is used to point at the other thread's flag
            while (MainPeterson.getFlag()[turn == 0 ? 1 : 0] && MainPeterson.getTurn() == turn) {
                // waste time
                faelles.wasteTime(10);
            }
            faelles.addCount();
            // Release lock
            MainPeterson.getFlag()[turn] = false;
            // Waste random time to start addcount at random intervals
            // (Is not actually needed here since the lock mechanism forces the threads to take turns)
            faelles.wasteTime(100);
        }
        printCounter("thread " + turn, faelles);

    }

}
