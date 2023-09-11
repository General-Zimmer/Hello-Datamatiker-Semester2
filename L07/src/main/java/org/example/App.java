package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        // Exercise 1
        ArrayList<Integer> listToSum = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        System.out.println(sumList(listToSum, 0, listToSum.size()-1));

        // Exercise 2
        ArrayList<Integer> ListToZero = new ArrayList<>(List.of(534, 756, 4532, 0, 532, 0, 54, 0));
        System.out.println(findTotalZeroes(ListToZero, 0, ListToZero.size()-1));

        // Exercise 3
        ArrayList<Integer> ListToSort = new ArrayList<>(List.of(8, 56, 45, 34, 15, 12, 34, 44));
        mergesort(ListToSort, 0, ListToSort.size()-1);
        System.out.println(ListToSort);
    }

    /**
     * Returnerer maksimum i s[l..h]
     * <p>
     *     Exorcise 1
     * Krav: l <= h
     */
    public static int sumList(List<Integer> list, int l, int h) {

        if (l == h) {
            return list.get(l);
        } else {
            int m = (l + h) / 2;
            int max1 = sumList(list, l, m);
            int max2 = sumList(list, m + 1, h);

            return max1 + max2;
        }
    }

    /**
     * Returnerer maksimum i s[l..h]
     * <p>
     *     Exorcise 2
     * Krav: l <= h
     */
    public static int findTotalZeroes(List<Integer> list, int l, int h) {

        if (l == h) {
            return (list.get(l) == 0) ? 1 : 0;
        } else {
            int m = (l + h) / 2;
            int max1 = findTotalZeroes(list, l, m);
            int max2 = findTotalZeroes(list, m + 1, h);

            return max1 + max2;

        }
    }

    private static void mergesort(ArrayList<Integer> list, int low, int high)
    {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(list, low, middle);
            mergesort(list, middle + 1, high);
            merge(list, low, middle, high);
        }
    }

    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> smolList = new ArrayList<>(list.subList(low, middle));
        ArrayList<Integer> bigList = new ArrayList<>(list.subList(middle+1, high));

        if (smolList.isEmpty() || bigList.isEmpty()) {
            return;
        }

        int i = 0;
        int j = 0;
        do {
            if (smolList.get(i) < bigList.get(j)) {
                temp.add(smolList.get(i));
                i++;
            } else {
                temp.add(bigList.get(j));
                j++;
            }
        } while (i < smolList.size() && j < bigList.size());


        int k = 0;
        int l = low;
        while (k < smolList.size()) {
            list.set(l, temp.get(k));
            k++;
            l++;
        }
    }

}
