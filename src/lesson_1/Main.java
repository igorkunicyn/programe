package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Apple[] apples = new Apple[10];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }
        Apple apple = new Apple();
        Box<Apple> appleBox = new Box<>();
        appleBox.addToBox(apple);
        appleBox.addToBox(apples);

        Orange[] oranges = new Orange[10];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }
        Orange orange = new Orange();
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addToBox(oranges);
        orangeBox.addToBox(orange);
        System.out.println("Вес коробки яблок: " + appleBox.getWeight());
        System.out.println("Вес коробки апельсин: " + orangeBox.getWeight());
        System.out.println("Коробка яблок тяжелее коробки апельсинов?: " + appleBox.compare(orangeBox));
        System.out.println("*********************************************************");

        Apple[] apples1 = new Apple[10];
        for (int i = 0; i < apples.length; i++) {
            apples1[i] = new Apple();
        }
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addToBox(apples1);
        System.out.println("Вес 1-й коробки яблок до пересыпания: " + appleBox.getWeight());
        System.out.println("Вес 2-й коробки яблок до пересыпания: " + appleBox1.getWeight());
        appleBox.moving(appleBox1);
        System.out.println("Вес 1-й коробки яблок после пересыпания: " + appleBox.getWeight());
        System.out.println("Вес 2-й коробки яблок после пересыпания: " + appleBox1.getWeight());
        System.out.println("*********************************************************");

        Integer[] integers = new Integer[]{3, 5, 7, 9, 10};
        String[] strings = new String[]{"dfg", "aaa", "bbb", "ccc", "ddd"};
        System.out.println("Массив integers до изменения: " + Arrays.toString(integers));
        System.out.println("Массив integers после изменения: " + Arrays.toString(strings));
        changeArrElement(integers, 0, 4);
        changeArrElement(strings, 1, 3);
        System.out.println("Массив strings до изменения: " + Arrays.toString(integers));
        System.out.println("Массив strings после изменения: " + Arrays.toString(strings));
        System.out.println("*********************************************************");

        System.out.println("Массив integers до преобразования: " + integers);
        System.out.println("Массив integers после преобразования: " + asArrayList(integers));
        System.out.println("Массив strings до преобразования: " + strings);
        ArrayList<String> stringArrayList = asArrayList(strings);
        System.out.println("Массив strings после преобразования: " + stringArrayList);

    }

    public static <T> void changeArrElement(T[] ts, int i, int j) {
        T o = ts[i];
        ts[i] = ts[j];
        ts[j] = o;
    }

    public static <T> ArrayList<T> asArrayList(T... ts) {
        ArrayList<T> list = new ArrayList(Arrays.asList(ts));
        return  list;
    }
}