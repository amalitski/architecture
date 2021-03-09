package com.architecture.abstractfactory;

import java.util.Arrays;

class SelectionSort implements SortInterface {
    private final int[] array;

    public  SelectionSort(int[] array) {
        this.array = array;
    }
    public int[] sort(){
        System.out.println(Arrays.toString(array));
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
        return array;
    }
    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
