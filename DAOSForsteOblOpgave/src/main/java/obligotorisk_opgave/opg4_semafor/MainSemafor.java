package obligotorisk_opgave.opg4_semafor;

import obligotorisk_opgave.models.Faelles;
import obligotorisk_opgave.opg4_semafor.threads.Taeller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

import static obligotorisk_opgave.utils.CommonUtil.runThreads;

public class MainSemafor {
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Thread thread1 = new Taeller(faelles, "Thread 1", semaphore);
        Thread thread2 = new Taeller(faelles, "Thread 2", semaphore);
        List<Thread> threads = new ArrayList<>(Arrays.asList(thread1, thread2));
        runThreads(threads, faelles);
    }
}
