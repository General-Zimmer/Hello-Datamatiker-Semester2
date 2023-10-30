package opgaver.app;

import opgaver.opg1.ArrayList23Y;
import opgaver.opg1.City;
import opgaver.opg2.SingleLinkedList23Y;
import opgaver.opg3.DoubleLinkedList23Y;

import java.util.Iterator;
import java.util.LinkedList;

public class DemoList23Y {

    public static void main(String[] args) {
        City paris = new City("Paris", 12_000_000);
        City rom = new City("Rom", 9_000_000);
        City london = new City("London", 9_000_000);
        City amsterdam = new City("Amsterdam", 7_000_000);
        City oslo = new City("Oslo", 1_200_000);

        //ArrayList23Y<City> list = new ArrayList23Y<>();
        //SingleLinkedList23Y<City> list = new SingleLinkedList23Y<>();
        DoubleLinkedList23Y<City> list = new DoubleLinkedList23Y<>();
        list.add(0,paris);
        System.out.println(list);
        list.add(1,amsterdam);
        System.out.println(list);
        list.add(2,london);
        list.add(rom);
        list.add(oslo);

        System.out.println(list);

        System.out.println("Size: " + list.size());
        System.out.println();

        list.remove(rom);
        list.remove(0);

        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println();

        //---------------------------------------------------------------------

        System.out.println("Print list with iterator:");
        Iterator<City> it = list.iterator();
        while (it.hasNext()) {
            City city = it.next();
            System.out.println(city);
        }
        System.out.println();

        System.out.println("Print list with for-each:");
        for (City city : list) {
            System.out.println(city);
        }
    }
}
