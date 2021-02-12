package lesson;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Road extends Stage {
    private final boolean numberRoad;
    private int countWin;
    private final static int ARGUMENT_FOR_SYNXR = MainClass.CARS_COUNT;
    private final static Runnable TASK_END =
        ()->System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    private static final CyclicBarrier cbEnd = new CyclicBarrier(ARGUMENT_FOR_SYNXR,TASK_END);
    private static final Lock lock = new ReentrantLock();

    Road(boolean b,int length) {
    this.length = length;
    this.description = "Дорога " + length + " метров";
    numberRoad = b;
    }
    @Override
    public void go(Car c) {
        try {
            if (!numberRoad){
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                System.out.println(c.getName() + " закончил этап: " + description);
            }else {
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                lock.lock();
                System.out.println(c.getName() + " закончил этап: " + description);
                countWin++;
                if (countWin == 1) {
                    System.out.println(c.getName() + " WIN ");
                }
                lock.unlock();
                cbEnd.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}