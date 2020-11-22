package lesson_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        changeElementsArray();
        inArray();
        multiplyArray();
        twoArray();
        findMinMaxArr();
        int[] a = {2,2,2,1,2,2,10,1};
        System.out.println(leftAndRightArr(a));
        int [] b ={3,5,6,1};
        int n=-2;
        shiftArr(b,n);
    }
    public static void changeElementsArray(){
        int [] a = {1,1,0,0,1,0,1,1,0,0};
        for (int i=0; i<a.length; i++){
            if (a[i]==0){
                a[i]=1;
            }else {
                a[i]=0;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void inArray(){
        int [] a = new int[8];
        for (int i=0; i<a.length; i++){
            a[i]=3*i;
        }
        for (int c: a ) System.out.print(c+" ");
        System.out.println();
    }
    public static void multiplyArray(){
        int [] a = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i=0; i<a.length; i++){
            if (a[i]<6){
                a[i]*=2;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void twoArray(){
        int [][] a = new int[5][5];
        for (int i=0; i<a.length;i++){
            for (int j=0; j<a[i].length;j++){
                if (i==j||i+j==4){
                    a[i][j]=1;
                }
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void findMinMaxArr(){
        int[] a= {7,-3,-5,-18,0,17,77};
        int min, max;
        min=max=a[0];
        for (int i = 1; i <a.length; i++) {
            if (a[i]<min){
                min = a [i];
            } else if (a[i]>max){
                max = a [i];
            }
        }
        System.out.println("Минимальное значение массива- "+min);
        System.out.println("Максимальное значение массива- "+max);
    }
    public static boolean leftAndRightArr(int [] b){
        int count=0;
        for (int i = 1; i <b.length; i++) {
            b[i]+=b[i-1];
            for (int j = b.length-2; j>=0 ; j--) {
                b[j]+=b[j+1];
                if (b[i]==b[j]){
                    count++;
                }
            }
        }
        return count>0;
    }
    public static void shiftArr(int [] a, int n){
        System.out.println(Arrays.toString(a));
        int m= Math.abs(n);
        if(n!=0) {
            for (int i = 0; i < m; i++) {
                if (n>0){
//                 сдвигаем массив вправо
                    int c = a[a.length - 1];
                    for (int j = a.length - 1; j > 0; j--) {
                        a[j] = a[j - 1];
                    }
                    a[0] = c;
                }else {
//                  сдвигаем массим влево
                    int c = a[0];
                    for (int j = 1; j <a.length; j++) {
                        a[j-1] = a[j];
                    }
                    a[a.length-1] = c;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
