package opgaver.opg3javasync;

import lombok.Getter;

public class Resturant {
    @Getter
    int counterBestillinger = 0;
    @Getter
    int counterMadPotioner = 0;
    final Object kokLock = new Object();
    public Resturant() {
    }

    public  int bestil() throws InterruptedException {
        synchronized (this) {
            int count = counterBestillinger;

            Thread.sleep(400);
            if (count >= counterMadPotioner)
                notify();
            counterBestillinger = ++count;
            return count;
        }
    }

    public synchronized int potionFærdig() throws InterruptedException {
        synchronized (kokLock) {
            if (this.getCounterBestillinger() <= this.getCounterMadPotioner()) {
                wait();
            }
            int count = counterMadPotioner + 1;
            Thread.sleep(400);
            counterMadPotioner = count;
            return count;
        }
    }


}
