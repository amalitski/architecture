package com.architecture.abstractfactory;

interface SortFactoryInterface {
    public SelectionSort sortSelection(int[] items);
    public InsertionSort sortInsertion(int[] items);
    public MergeSort sortMerge(int[] items);
}
