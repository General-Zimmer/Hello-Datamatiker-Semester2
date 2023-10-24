package obligotorisk_opgave.opg1_nosync;

import obligotorisk_opgave.common_utils.models.Faelles;
import obligotorisk_opgave.opg1_nosync.threads.Taeller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static obligotorisk_opgave.common_utils.CommonUtil.runThreads;

public class MainNosync {

    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Thread thread1 = new Taeller(faelles, "Thread 1");
        Thread thread2 = new Taeller(faelles, "Thread 2");
        List<Thread> threads = new ArrayList<>(Arrays.asList(thread1, thread2));
        runThreads(threads, faelles);
    }
}
