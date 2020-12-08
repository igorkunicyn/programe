package lesson_7;

public class Main {
    public static void main(String[] args) {
        Cat [] cat = {new Cat("Barsik", 55),
        new Cat("Myrzik", 30),
        new Cat("Pushok",25),
        new Cat("Vaska",20)};
        Plate plate = new Plate(90);
        for (int i = 0; i < cat.length ; i++) {
            plate.info();
            cat[i].eat(plate, cat[i]);
            plate.info();
            System.out.println();
        }
    }

}
