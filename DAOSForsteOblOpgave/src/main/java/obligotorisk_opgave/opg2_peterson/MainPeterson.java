package obligotorisk_opgave.opg2_peterson;

import obligotorisk_opgave.common_utils.models.Faelles;
import obligotorisk_opgave.opg2_peterson.threads.Taeller;

public class MainPeterson {

    private static final boolean[] flag = new boolean[2];
    private static int turn = 0;

    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Thread thread1 = new Taeller(faelles, 1);
        Thread thread2 = new Taeller(faelles, 0);

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

    public static boolean[] getFlag() {
        return flag;
    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int turnParam) {
        turn = turnParam;
    }
}
