package obligotorisk_opgave.common_utils.models;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class Faelles {
    private int counter = 0;

    public void wasteTime(int max) {
        double amount = max * Math.random();

        double counter = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < amount; j++) {
                counter = i*i+amount;
            }

        }
    }
    public int getCounter() {
        return counter;
    }

    public void addCount() {
        // create a variable in the cpu cache
        int temp = counter;
        // waste time
        wasteTime(1000);
        // increment the variable
        counter = temp+1;
    }
}
