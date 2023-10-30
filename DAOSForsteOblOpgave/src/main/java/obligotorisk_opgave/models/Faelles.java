package obligotorisk_opgave.models;

public class Faelles {
    private int counter = 0;

    public void wasteTime(double max) {
        wasteTime(max, 3);
    }

    private void wasteTime(double size, int loopAmount) {
        double amount = size * Math.random();
        loopAmount--;

        // Can slowly increase the size of loops
        for (int i = 0; i < amount; i++)
            size = 10+(size * (Math.random()+0.5));

        if (loopAmount >= 0)
            wasteTime(size, loopAmount);
    }
    public int getCounter() {
        return counter;
    }

    public void addCount() {
        // create a variable in the cpu cache
        int temp = counter;
        // waste time to randomize the incrementation time
        wasteTime(100, 100);
        // increment the variable
        counter = temp+1;
    }
}
