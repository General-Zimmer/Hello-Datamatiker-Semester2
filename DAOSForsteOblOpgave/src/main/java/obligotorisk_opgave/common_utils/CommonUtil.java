package obligotorisk_opgave.common_utils;

public class CommonUtil {

    public static void wasteTime(int max) {
        double amount = max * Math.random();

        double counter = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < amount; j++) {
                counter = i*i+amount;
            }

        }
    }
}
