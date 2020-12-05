package lesson_6;

public class Dog extends Animal{
    static int number;
    Dog(String name, String color, int age, int number){
        super(name, color, age);
        this.number=number;
    }
    @Override
    void run(int length){
        if (length<500){
            System.out.println(name + " пробежал "+length+ " м.");
        }else {
            System.out.println(name + " не может пробежать "+length+ " м.");
        }
    }
    @Override
    void swim(int length){
        if (length<10){
            System.out.println(name + " проплыл "+length+ " м.");
        }else {
            System.out.println(name + " не может проплыть "+length+ " м.");
        }
    }
    public int getNumberDog(){
        return number;
    }
}
