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

        // bonus ting tang
        ArrayList<Integer> ListToKock = new ArrayList<>(List.of(8, 56, 45, 34, 15, 12, 34, 44));
        quickSort(ListToKock);
        System.out.println(ListToKock);
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

    /**
     * Merge two sorted sublists into one sorted list
     * <p>
     *     Test array 8, 56, 45, 34, 15, 12, 34, 44
     * @param list The list to sort
     * @param low The lowest index to sort
     * @param middle The middle index to sort
     * @param high The highest index to sort
     */
    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> arr = new ArrayList<>();

        int i = low;
        int j = middle+1;
        while (i <= middle && j <= high) {
            int smol = list.get(i);
            int big = list.get(j);
            if (smol > big) {
                arr.add(list.get(j));
                j++;
            } else {
                arr.add(list.get(i));
                i++;

            }
        }

        while(i<=middle){
            arr.add(list.get(i));
            i++;
        }

        while(j<=high){
            arr.add(list.get(j));
            j++;
        }

        for (int k : arr) {
            list.set(low, k);
            low++;
        }

    }



    private static void swap(ArrayList<Integer> list, int k, int l) {
        int temp = list.get(k);
        list.set(k, list.get(l));
        list.set(l, temp);
    }
    private static void quickSort(ArrayList<Integer> list, int low, int high){
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p-1);
            quickSort(list, p+1, high);
        }
    }
    private static int partition(ArrayList<Integer> list, int low, int high) {
        int e = list.get(low);
        int i = low + 1;
        int j = high;
        while (i <=j) {
            if (list.get(i) <= e) { i++; }
            else if (list.get(j) > e) { j--; }
            else {
                swap(list, i, j);
                i++;
                j--;
            }
        }
        swap(list, low, j);
        return j;
    }
    public static void quickSort(ArrayList<Integer> list) {
        quickSort(list, 0, list.size()-1);
    }


}
