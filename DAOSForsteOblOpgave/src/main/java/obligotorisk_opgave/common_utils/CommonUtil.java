package obligotorisk_opgave.common_utils;

import obligotorisk_opgave.common_utils.models.Faelles;

import java.util.List;

public class CommonUtil {

    public static void printCounter(String name, Faelles faelles) {
        System.out.println(name + " finished with " + faelles.getCounter());
    }

    public static void runThreads(List<Thread> threads, Faelles faelles) {
        threads.forEach(Thread::start);


        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        System.out.println(faelles.getCounter());
    }
}
