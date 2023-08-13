package ru.geekbrains.lesson1.example;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = getSum(n);
        System.out.println("sum = " + sum);
    }

    /**
     * Необходимо написать алгоритмы, считающий сумму всех чисел от 1 до N
     *
     * @param n число до которого необходимо суммировать
     * @return сумма
     */
    private static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
