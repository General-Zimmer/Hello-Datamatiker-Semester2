package opgaver.opg2semafor;

import lombok.Getter;

import java.util.concurrent.Semaphore;

public class Resturant {
    @Getter
    int counterBestillinger = 0;
    @Getter
    int counterMadPotioner = 0;
    @Getter
    private Semaphore tjenerLock = new Semaphore(1);
    @Getter
    private Semaphore kokLock = new Semaphore(1);


    public int bestil() {
        int count = counterBestillinger+1;
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counterBestillinger = count;
        return count;
    }

    public int potionFærdig() {
        int count =  counterMadPotioner+1;
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counterMadPotioner = count;
        return count;
    }


}
