package lesson_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Apple [] apples = new Apple []{new Apple(0.1f),new Apple(0.1f),new Apple(0.1f),
        new Apple(0.1f),new Apple(0.1f),new Apple(0.1f)};
        Apple apple = new Apple(0.1f);
        Box <Apple> appleBox = new Box<Apple>();
        appleBox.addToBox(apple);
        appleBox.addToBox(apples);

        Orange [] oranges = new Orange[] {new Orange(1.5f),new Orange(1.5f),new Orange(1.5f),
        new Orange(1.5f),new Orange(1.5f),new Orange(1.5f)};
        Orange orange = new Orange(1.5f);
        Box <Orange> orangeBox = new Box<Orange>();
        orangeBox.addToBox(oranges);
        orangeBox.addToBox(orange);
        System.out.println(appleBox.getBox());
        System.out.println(orangeBox.getBox());
    }
}
