package opgaver.opg3javasync;

import lombok.Getter;

public class Resturant {
    @Getter
    int counterBestillinger = 0;
    @Getter
    int counterMadPotioner = 0;
    public Resturant() {
    }

    public int bestil() throws InterruptedException {
        synchronized (this) {
            int count = counterBestillinger;

            Thread.sleep(400);
            if (count >= counterMadPotioner)
                notifyAll();
            counterBestillinger = ++count;
            return count;
        }
    }

    public int potionFærdig() throws InterruptedException {
        synchronized (this) {
            if (this.getCounterBestillinger() <= this.getCounterMadPotioner()) {
                wait();
            }
            int count = counterMadPotioner + 1;
            Thread.sleep(100);
            counterMadPotioner = count;
            return count;
        }
    }


}
