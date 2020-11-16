package lesson_1;


import static java.lang.System.*;

public class Main {
    public static void main(String[]args) {
        printVariable();
        out.println(rezCount(2.3456F,6.8908F,89.9876F,7.678F));
        out.println(testSum(8,14));
        whatIsNumber(-5);
        out.println(whatIsNumber2(-2));
        helloName("Андрей");
        whatIsYear(300);
    }
    public static void printVariable(){
        byte b = 121;
        short s = 1002;
        int i = 20989;
        long l = 239000990765544L;
        float f = 2.5678F;
        double d = 3.8990002378;
        char c = 'f';
        boolean boo = false;
        String text = "Hello, world";
        out.println(b+" | "+s+" | "+i+" | "+l+" | "+f+" | "+d+" | "+c+" | "+boo+" | "+text);
    }
    public static float rezCount(float a, float b, float c, float d){
       return a*(b+(c/d));
    }
    public static boolean testSum(int a,int b){
        return a+b>=10 && a+b<=20;
    }
    public static void whatIsNumber(int a){
        if (a>=0){
            out.println("Введенное число - положительное");
        } else {
            out.println("Введенное число - отрицательное");
        }
    }
    public static boolean whatIsNumber2(int a){
        return a<0;
    }
    public static void helloName(String text){
        out.println("Привет,"+text+"!");
    }
    public static void whatIsYear(int a){
        if ((a%4==0&&!(a%100==0))||a%400==0){
            out.println("Введенный Вами год - високосный");;
        }else {
            out.println("Введенный Вами год - невисокосный");;
        }
    }
}