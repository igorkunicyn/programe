package lesson_6;

import java.util.Random;

public class Main {
    Random random = new Random();

    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
        map.put(1, 10);
        map.put(-2, 20);
        map.put(4, 30);
        map.put(3, 1);
        map.put(0, 18);
        map.put(6, -5);
        map.put(-5, 27);
        map.put(-4, -20);
        map.put(9, -4);
        map.put(5, -1);
        map.put(-1, 10);
        map.put(-12, 15);
        map.put(13, 19);
        map.put(2, 25);
        map.put(-3, 28);
        if (map.isBalanced(map.getRoot())){
            System.out.println("Построенное дерево сбалансировано");
        }else {
            System.out.println("Построенное дерево не сбалансировано");
        }
//        System.out.println(createItegerMap(100, -100));
        System.out.println("Число сбалансированных деревьев  " + numberOfBalancedMap(100000, -100, 100));
    }

    public static int numberOfBalancedMap(int number, int max, int min){
        int count = 0;
        MyTreeMap map;
        for (int i = 0; i < number; i++) {
            map = createItegerMap(max, min);
            if (map.isBalanced(map.getRoot())){
                count++;
            }
        }
        if (count == 0){
            return 0;
        }
        return count;
    }
    public static MyTreeMap<Integer,Integer> createItegerMap(int max, int min){
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
        int key = 0;
        int value = 0;

        while (map.height(map.getRoot()) < 6){
           key = min +(int)(Math.random()*((max - min) + 1));
           value++;
           map.put(key, value);
        }
        return map;
    }
}

