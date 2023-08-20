package ru.geekbrains.sortyng_types;

import ru.geekbrains.lesson2.example.Ex01;

public class BubbleSort {
    public static void main(String[] args) {
        int size = 10;
        int min = 1;
        int max = 100;
        int [] array =  Ex01.getRandomArr(size, min, max);
        Ex01.printArr(array);
        bubbleSort(array);
        Ex01.printArr(array);
    }

    public static void bubbleSort(int [] array) {
        int length = array.length;
        while (length != 0) {
            int max_index = 0;
            for (int i = 1; i < length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    max_index = i;
                }
            }
            length = max_index;
        }

    }
}
