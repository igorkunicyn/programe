package lesson;



public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        Race race = new Race(new Road(false,60), new Tunnel(), new Road(true,40));
        for (int i = 0; i < CARS_COUNT; i++) {
            new Car(race, 20 + (int) (Math.random() * 10));
        }
    }
}




