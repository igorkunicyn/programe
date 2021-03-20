package lesson_3;


public class Main {
    public static void main(String[] args) {

//        Expression expression = new Expression("(( [7] + {-8*a} + t ])");
//        System.out.println(expression.checkBracket());
//        MyQueue<Integer> myQueue = new MyQueue<>(5);
//        MyDeque<Integer> myQueue = new MyDeque<>(5);
//        for (int i = 1; i < 6; i++) {
//            myQueue.insertLeft(i);
//        }

        MyDeque myDeque = new MyDeque(5);
        myDeque.insertRight(10);
        myDeque.insertLeft(1);
        myDeque.insertLeft(2);
        myDeque.insertRight(11);
        myDeque.insertLeft(3);
        System.out.println(myDeque);
        myDeque.removeLeft();
        myDeque.removeRight();
        System.out.println(myDeque);
        myDeque.insertLeft(2);
        myDeque.insertRight(11);
        myDeque.insertLeft(3);
        System.out.println(myDeque);

//        Expression expression = new Expression("Hello, world!");
//        expression.changeString();

    }

}
