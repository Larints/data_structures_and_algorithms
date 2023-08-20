package ru.geekbrains.red_black_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.addNode(value);
                    System.out.println("finish");
                } catch (Exception ignored) {
                }
            }
        }
    }
}
