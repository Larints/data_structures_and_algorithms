package ru.geekbrains.sortyng_types;

import ru.geekbrains.lesson2.example.Ex01;

public class SelectionSort {
    public static void main(String[] args) {
        int size = 100;
        int min = 1;
        int max = 50;
        int[] array = Ex01.getRandomArr(size, min, max);
        Ex01.printArr(array);
        selectionSort(array);
        Ex01.printArr(array);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) minIndex = j;
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}

