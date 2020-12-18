package lesson_1_2;


public class Human implements RunAndJumpable {
    private String name;
    static double maxlength;
    static double maxheigth;
    Human(String s){
        name = s;
        maxheigth=2;
        maxlength=2000;
    }
    public void run(){
        System.out.println("Human "+name+" knows run");
    }
    public void jump(){
        System.out.println("Human "+name+" knows jump");
    }

    public String getName() {
        return "Human "+name;
    }

    @Override
    public double getMaxheigth() {
        return maxheigth;
    }

    @Override
    public double getMaxlength() {
        return maxlength;
    }
}