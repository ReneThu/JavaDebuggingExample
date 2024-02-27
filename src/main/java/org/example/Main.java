package org.example;

public class Main {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(String.format("%s + 2 = %s", number, addTwo(number)));
    }

    public static Integer addTwo(int i) {
        try {
            int two = 2;
            return i - two;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}