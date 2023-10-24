package obligotorisk_opgave.opg2_peterson;

import obligotorisk_opgave.opg2_peterson.threads.Taeller;

public class MainPeterson {

    private static int[] counter = new int[1];
    private static final boolean[] flag = new boolean[2];
    private static int turn = 0;

    public static void main(String[] args) {
        Thread thread1 = new Taeller(counter, true, 1);
        Thread thread2 = new Taeller(counter, false, 0);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(counter[0]);
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
