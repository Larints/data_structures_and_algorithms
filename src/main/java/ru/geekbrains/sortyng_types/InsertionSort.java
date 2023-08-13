package ru.geekbrains.sortyng_types;

import ru.geekbrains.lesson2.example.Ex01;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = Ex01.getRandomArr(10, 1, 10);
        Ex01.printArr(array);
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int sorted = i - 1;
            while (sorted > -1 && array[sorted] > array[sorted + 1]) {
                int temp = array[sorted];
                array[sorted] = array[sorted + 1];
                array[sorted + 1] = temp;
                sorted--;
            }
        }
    }
}