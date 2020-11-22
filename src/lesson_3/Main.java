package lesson_3;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random random=new Random();
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        guessNumber();
        guessWord();
    }
    public static int randomNumber(int c, int d){
        int a =random.nextInt(c)+d;
        return a;
    }
    public static void guessNumber(){
        int min = 0, max=10;
        int a=randomNumber(max,min);
        for (int j = 0; j < 1e9; j++) {
            System.out.println("Компютер загадал число от "+min+" до "+(max-1)+"\n"+
                    "Ваша задача угадать число, которое загадал компьютер.\n"+
                            "У Вас 3 попытки.Начали!");
            for (int i = 0; i < 3;i++) {
                System.out.println("Введите число:");
                int b = scanner.nextInt();
                if (a > b) {
                    System.out.println("Загаданное число больше.");
                    } else if (a < b) {
                    System.out.println("Загаданное число меньше.");
                    } else {
                    System.out.println("Вы угадали!");
                    break;
                    }
                }
                System.out.println("Повоторить игру еще раз?1-да/0-нет");
                int c = scanner.nextInt();
                if (c == 1) {
                    j++;
                }else {
                    break;
                }
        }
    }
    public static String [] arrWords(){
        String[] ss = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        return ss;
    }
    public static String randomWord(int n, String [] strings){
        return strings[n];
    }
    public static void guessWord(){
        int n = random.nextInt(arrWords().length - 1);
        String s = randomWord(n, arrWords());
        System.out.println("Ваша задача - угадать загаданное компьютером слово.\n"+
        "Если слово не угадано - компютер покажет буквы, стоящие на своих местах в слове");
        for (int k = 0; k <100;) {
            StringBuilder txt = new StringBuilder();
            System.out.println("Введите слово:");
            String word = scanner.nextLine();
            int m = Math.min(word.length(), s.length());
            for (int i = 0; i < m; i++) {
                char a = word.charAt(i);
                char b = s.charAt(i);
                if (a == b) {
                    txt.append(a);
                } else {
                    txt.append("#");
                }
            }
            if (txt.toString().equals(word)) {
                System.out.println("Вы угадали!");
                k=100;
            } else {
                int d = txt.length();
                for (int i = 0; i < 15 - d; i++) {
                    txt.append("#");
                }
                System.out.println(txt);
            }
            k++;
            }
        }
}
