package obligotorisk_opgave.opg2_peterson.threads;

import lombok.Getter;
import lombok.Setter;
import obligotorisk_opgave.common_utils.CommonUtil;
import obligotorisk_opgave.opg2_peterson.MainPeterson;

public class Taeller extends Thread {

    int[] counter;
    private final boolean flag;
    private int turn;
    public Taeller(int[] counter, boolean flag, int turn) {
        this.counter = counter;
        this.flag = flag;
        this.turn = turn;
    }
    @Override
    public void run() {




        for (int i = 0; i < 100; i++) {
            // Peterson lock ting tang
            MainPeterson.getFlag()[turn] = true;
            MainPeterson.setTurn(turn);
            // Note: turn == 0 ? 1 : 0 is a ternary operator and is used to check for the other thread's flag
            while (MainPeterson.getFlag()[turn == 0 ? 1 : 0] && MainPeterson.getTurn() == turn) {
                CommonUtil.wasteTime(10000000);
            }
            // Critical section
            counter[0]++;
            MainPeterson.getFlag()[turn] = false;
            CommonUtil.wasteTime(1000000);
        }
        System.out.println("thread:" + turn + " finished with " + counter[0]);
        // Release lock


    }


}
