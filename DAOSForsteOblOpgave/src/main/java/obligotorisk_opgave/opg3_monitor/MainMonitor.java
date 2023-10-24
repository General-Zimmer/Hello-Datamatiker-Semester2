package obligotorisk_opgave.opg3_monitor;

import obligotorisk_opgave.models.Faelles;
import obligotorisk_opgave.opg3_monitor.threads.Taeller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static obligotorisk_opgave.utils.CommonUtil.runThreads;

public class MainMonitor {

    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Thread thread1 = new Taeller(faelles, "Thread 1");
        Thread thread2 = new Taeller(faelles, "Thread 2");
        List<Thread> threads = new ArrayList<>(Arrays.asList(thread1, thread2));
        runThreads(threads, faelles);
    }
}
