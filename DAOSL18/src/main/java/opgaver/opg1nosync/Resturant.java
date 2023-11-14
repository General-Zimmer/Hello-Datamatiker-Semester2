package opgaver.opg1nosync;

import lombok.Getter;

public class Resturant {
    @Getter
    int counterBestillinger = 0;
    @Getter
    int counterMadPotioner = 0;

    public Resturant() {
    }

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
        int count = counterMadPotioner+1;
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counterMadPotioner = count;
        return count;
    }


}
