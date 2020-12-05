package lesson_6;

public class Main {
    public static void main(String[] args) {
        Cat cat1=new Cat("Barsik", "black", 5, 1);
        Dog dog1=new Dog("Muxtar", "black", 5, 1);
        Dog dog2=new Dog("Reks", "red", 4, 2);
        Cat cat2=new Cat("Myrsik", "red", 4, 2);
        Cat cat3=new Cat("Marsik", "blue", 2, 3);
        Dog dog3=new Dog("Bim", "blue", 2, 3);
        System.out.println("Количество котов: "+ cat1.getNumberCat());
        cat1.run(195);
        cat2.run(250);
        cat3.swim(50);
        System.out.println();
        System.out.println("Количество собак: "+ dog1.getNumberDog());
        dog1.run(395);
        dog2.run(550);
        dog2.swim(50);
        dog3.swim(9);
        System.out.println();
        System.out.println("Всего животных: "+(cat1.getNumberCat()+dog1.getNumberDog()));
        System.out.println();
        Animal.number=Cat.number+Dog.number;
        System.out.println("Всего животных: "+Animal.number);
//        Animal [] animals= {new Cat("Barsik", ",black", 5, 1),
//                new Dog("Tyzik","white", 4,2)};
//        animals[0].run(190);
//        animals[0].swim(0);
//        animals[1].run(100);
//        animals[1].swim(5);
//        System.out.println("Всего животных: "+ animals.length);
//        int numbercat=0;
//        for (int i = 0; i < animals.length; i++) {
//            if (Cat.class.equals(animals[i].getClass()))numbercat++;
//        }
//        System.out.println("Всего котов: "+numbercat );
//        int numberdog=0;
//        for (int i = 0; i < animals.length; i++) {
//            if (Dog.class.equals(animals[i].getClass()))numberdog++;
//        }
//        System.out.println("Всего собак: "+numberdog );
//
    }
}
