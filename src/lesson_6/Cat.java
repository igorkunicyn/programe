package lesson_6;

public class Cat extends Animal {
    static int number;
    Cat(String name, String color, int age, int number){
        super(name, color, age);
        this.number=number;
    }
    @Override
    void run(int length){
        if (length<200){
            System.out.println(name + " пробежал "+length+ " м.");
        }else {
            System.out.println(name + " не может пробежать "+length+ " м.");
        }
    }
    @Override
    void swim(int length){
        System.out.println(name+" не умеет плавать.");
    }
    public int getNumberCat(){
        return number;
    }

}
