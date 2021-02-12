package lesson;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Car implements Runnable{
        private static int NUMBER_CARS;
        private final Race race;
        private final int speed;
        private final String name;
        private final static int ARGUMENT_FOR_SYNXR = MainClass.CARS_COUNT;
        private final static Runnable TASK_BEGIN =
                ()->System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        private final static Runnable TASK_START =
                ()->System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        private final static CyclicBarrier cbBegin = new CyclicBarrier(ARGUMENT_FOR_SYNXR,TASK_BEGIN);
        private final static CyclicBarrier cbStart = new CyclicBarrier(ARGUMENT_FOR_SYNXR,TASK_START);
        public String getName() {
            return name;
        }
        public int getSpeed() {
            return speed;
        }

        Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        NUMBER_CARS++;
        this.name = "Участник #" + NUMBER_CARS;
        new Thread(this).start();
    }

        @Override
        public void run() {
            try {
                cbBegin.await();
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int)(Math.random() * 800));
                System.out.println(this.name + " готов");
                cbStart.await();
                for (int i = 0; i < race.getStages().size(); i++) {
                    race.getStages().get(i).go(this);
                }

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
}
