package lesson_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {


        Random r = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            mal.add(r.nextInt(100));
        }
        System.out.println(mal);


//        mal.selectionSort();
//        mal.insertionSort();
        mal.bubbleSort();


        System.out.println(mal);


    }
}
