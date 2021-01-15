package lesson_2_4;


public class Main {
    static final int SIZE = 10_000_000;
    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        MyArrays myArrays =new MyArrays();
        myArrays.oneMethod(arr);
        myArrays.twoMethod(arr);
        myArrays.threeMethod(arr);
        System.out.println("Главный поток завершен");
    }
}