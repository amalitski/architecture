package com.architecture.abstractfactory;

class SortFactory implements SortFactoryInterface{
    public SelectionSort sortSelection(int[] array) {
        return new SelectionSort(array);
    }
    public InsertionSort sortInsertion(int[] array){
        return new InsertionSort(array);

    }
    public MergeSort sortMerge(int[] array){
        return new MergeSort(array);
    }
}
