package lesson_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {


        Random r = new Random();
        int n = 100000;
        MyArrayList<Integer> mal = new MyArrayList<>(n);
        for (int i = 0; i < n; i++) {
            mal.add(r.nextInt(n));
        }
        long a = System.currentTimeMillis();
        mal.selectionSort();
        long b = System.currentTimeMillis();
        System.out.println(b-a);
        a = System.currentTimeMillis();
        mal.insertionSort();
        b = System.currentTimeMillis();
        System.out.println(b-a);
        a = System.currentTimeMillis();
        mal.bubbleSort();
        b = System.currentTimeMillis();
        System.out.println(b-a);

    }
}
