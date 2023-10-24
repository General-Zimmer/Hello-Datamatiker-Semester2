package obligotorisk_opgave.common_utils;

import obligotorisk_opgave.common_utils.models.Faelles;

public class CommonUtil {

    public static void printCounter(String name, Faelles faelles) {
        System.out.println(name + " finished with " + faelles.getCounter());
    }
}
