package lesson_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RunAndJumpable [] runAndJumpables = {new Human("John"),(RunAndJumpable)new Robot("Boy"),
                (RunAndJumpable) new Cat("Barsik")};
//        for (int i = 0; i <runAndJumpables.length ; i++) {
//                runAndJumpables [i].jump();
//                runAndJumpables[i].run();
//        }

        Overcomeable [] overcomeables = {new RunningTrack(), new Wall()};
//        for (int i = 0; i <runAndJumpables.length ; i++) {
//            for (int j = 0; j < overcomeables.length ; j++) {
//                overcomeables[j].notOvercoming(runAndJumpables[i].getName());
//                overcomeables[j].overcoming(runAndJumpables[i].getName());
//            }
//        }
        int k = (int)(Math.random()*10);//случайным образом определяем последовательность припятствий
        for (int i = 0; i < k; i++) {
            Overcomeable overcomeable = overcomeables[0];
            overcomeables[0] = overcomeables[1];
            overcomeables[1] = overcomeable;
        }

        for (int i = 0; i < runAndJumpables.length ;i++ ) {
            for (int j = 0; j <overcomeables.length  ;j++ ) {
                if (j==0){
                    System.out.println();
                    System.out.println(runAndJumpables[i].getName()+" начал соревнования!");
                }
                if (overcomeables[j].getName() == RunningTrack.name) {
                    if (!overcomeables[j].overOrNotOver(runAndJumpables[i].getName(), runAndJumpables[i].getMaxlength())){
                        break;
                    }
                } else if (overcomeables[j].getName() == Wall.name) {
                    if (!overcomeables[j].overOrNotOver(runAndJumpables[i].getName(), runAndJumpables[i].getMaxheigth())){
                        break;
                    }
                }
                if (j==overcomeables.length-1){
                    System.out.println(runAndJumpables[i].getName()+" закончил соревнования!");
                    System.out.println();
                }
            }
        }
        System.out.println();
        DayOfWeek.getWorkingHouse(DayOfWeek.WEDNESDAY.getNumber());
    }
}
