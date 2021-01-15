package lesson_2_4;

import java.util.Arrays;

public class MyArrays {
    static final int NUMBER_THREAD = 30;
   void oneMethod(float [] arr){
        long a, b;
        Arrays.fill(arr, 1);
        a = System.currentTimeMillis();
        for (int i = 0; i < arr.length ; i++) {
            arr [i] = (float) (arr[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+ i/5)*
                    Math.cos(0.4f+i/2));
        }
        b = System.currentTimeMillis();
        System.out.println("Время просчета массива для первого метода: "+ (b-a));
       System.out.println();
    }
    void twoMethod(float [] arr){
        long a, b;
        int h = arr.length/2;
        Arrays.fill(arr, 1);
        float [] a1 = new float[h];
        float [] a2 = new float[h];
        a = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr,h,a2,0,h);
        b = System.currentTimeMillis();
        System.out.println("Время разбивки массива на 2 массива для второго метода: "+ (b-a));
        a = System.currentTimeMillis();
        MyClass myClass1 = new MyClass("Один", a1);
        MyClass myClass2 = new MyClass("Два", a2);
        b = System.currentTimeMillis();
        System.out.println("Время просчета массива для второго метода: "+ (b-a));
        a = System.currentTimeMillis();
        System.arraycopy(myClass1.getArr(),0,arr,0,h);
        System.arraycopy(myClass2.getArr(),0,arr,h,h);
        b = System.currentTimeMillis();
        System.out.println("Время склейки массивов для второго метода: "+ (b-a));
        System.out.println();
    }
    void threeMethod(float [] arr){
        long a, b;
        int h = arr.length/NUMBER_THREAD;
        MyClass [] myClasses = new MyClass[NUMBER_THREAD];
        Arrays.fill(arr, 1);
        float [] [] array = new float[NUMBER_THREAD][];
        a = System.currentTimeMillis();
        for (int i = 0; i <NUMBER_THREAD ; i++) {
            array [i] = new float[h];
            System.arraycopy(arr,i*h,array[i],0,h);
        }
        b = System.currentTimeMillis();
        System.out.println("Время разбивки массива на "+NUMBER_THREAD+" массивов: "+ (b-a));
        a = System.currentTimeMillis();
        for (int i = 0; i <NUMBER_THREAD ; i++) {
            myClasses[i] = new MyClass(String.valueOf(i),array[i]);
        }
        b = System.currentTimeMillis();
        System.out.println("Время просчета массива для третьего метода: "+ (b-a));
        a = System.currentTimeMillis();
        for (int i = 0; i <NUMBER_THREAD ; i++) {
            System.arraycopy(myClasses[i].getArr(),0,arr,i*h,h);
        }
        b = System.currentTimeMillis();
        System.out.println("Время склейки массивов для третьего метода: "+ (b-a));
    }
}
