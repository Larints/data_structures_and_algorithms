package ru.geekbrains.lesson1.example;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) throws Exception {

        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();
        iScan.close();

        System.out.println(fiboRecursion(n));
    }

    /**
     * @param pos - position to find
     * @return value of the element
     * @apiNote Algorithm of Fibonacci by recursion
     */
    public static int fiboRecursion(int pos) {
        if (pos == 1 || pos == 2) {
            return 1;
        }

        return fiboRecursion(pos - 1) + fiboRecursion(pos - 2);
    }

}
