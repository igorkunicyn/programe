package lesson_1;

public class Robot implements RunAndJumpable{
    private String name;
    static double maxlength;
    static double maxheigth;
    Robot(String s){
        name = s;
        maxheigth=1;
        maxlength=500;
    }
    public void run(){
        System.out.println("Robot "+name+" knows run");
    }
    public void jump(){
        System.out.println("Robot "+name+" knows jump");
    }

    public String getName() {
        return "Robot "+name;
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