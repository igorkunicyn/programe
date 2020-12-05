package lesson_6;

class Animal {
    String name;
    String color;
    int age;
    int length;
    static int number;

    Animal(String name, String color, int age){
        this.name= name;
        this.color = color;
        this.age = age;
//        this.number=number;
    }

    void run(int length){
        this.length=length;
        System.out.println(name+" пробежал "+length+" м.");
    }
    void swim(int length){
        this.length=length;
        System.out.println(name+" проплыл "+length+" м.");
    }

}
