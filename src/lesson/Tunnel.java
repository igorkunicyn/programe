package lesson;

import java.util.concurrent.Semaphore;

 class Tunnel extends Stage {
    private final static Semaphore smf = new Semaphore(MainClass.CARS_COUNT/2);

    Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smf.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            smf.release();
            }
    }
}

