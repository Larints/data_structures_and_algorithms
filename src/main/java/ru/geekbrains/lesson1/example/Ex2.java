package ru.geekbrains.lesson1.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        List<Integer> result = new ArrayList<Integer>();
        findPrimeNumbers(n, result);
        System.out.println("result = " + result);
    }

    /**
     * Метод для нахождения простых чисел от 1 до N
     *
     * @param n      - пользовательский ввод значения с клавиатуры
     * @param result - вывод результата
     */

    private static void findPrimeNumbers(int n, List<Integer> result) {
        for (int i = 1; i <= n; i++) {
            if (isFind(i)) {
                result.add(i);
            }
        }
    }

    private static boolean isFind(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

}
