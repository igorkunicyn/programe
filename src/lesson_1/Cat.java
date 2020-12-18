package lesson_1;

public class Cat implements RunAndJumpable{
    private String name;
    static double maxlength;
    static double maxheigth;
    Cat(String s){
        name = s;
        maxheigth=3;
        maxlength=1000;
    }
    public void run(){
        System.out.println("Cat "+name+" knows run");
    }
    public void jump(){
        System.out.println("Cat "+name+" knows jump");
    }

     public String getName() {
        return "Cat "+name;
    }
     public double getMaxlength(){
        return maxlength;
    }

    @Override
    public double getMaxheigth() {
        return maxheigth;
    }
}
