package ru.geekbrains.sortyng_types;

import ru.geekbrains.lesson2.example.Ex01;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = Ex01.getRandomArr(10, 1, 10);
        Ex01.printArr(array);
        quickSort(array);
        Ex01.printArr(array);
    }

    public static int partOfQuickSort(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int rightStart = partOfQuickSort(array, left, right);
        quickSort(array, left, rightStart - 1);
        quickSort(array, rightStart, right);
    }

    public static void quickSort(int[]array) {
        quickSort(array, 0, array.length - 1);
    }
}
