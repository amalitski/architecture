package com.architecture.abstractfactory;

import java.util.Arrays;

class MergeSort implements SortInterface {
    private final int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        return sort(array);
    }

    private static int[] sort(int[] items) {
        if (items.length < 2) {
            return items;
        } else {
            int[] left = sort(Arrays.copyOfRange(items, 0, items.length / 2));
            int[] right = sort(Arrays.copyOfRange(items, items.length / 2, items.length));
            return merge(left, right);
        }
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        if (i == left.length) {
            while (j < right.length) {
                result[k] = right[j];
                j++;
                k++;
            }
        }
        if (j == right.length) {
            while (i < left.length) {
                result[k] = left[i];
                i++;
                k++;
            }
        }
        return result;
    }
}
