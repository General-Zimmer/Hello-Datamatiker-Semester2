package obligotorisk_opgave.opg2_peterson;

import obligotorisk_opgave.models.Faelles;
import obligotorisk_opgave.opg2_peterson.threads.Taeller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static obligotorisk_opgave.utils.CommonUtil.runThreads;

public class MainPeterson {

    private static final boolean[] flag = new boolean[2];
    private static int turn = 0;

    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Thread thread1 = new Taeller(faelles, 1);
        Thread thread2 = new Taeller(faelles, 0);
        List<Thread> threads = new ArrayList<>(Arrays.asList(thread1, thread2));
        runThreads(threads, faelles);
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
