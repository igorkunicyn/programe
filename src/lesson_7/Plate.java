package lesson_7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n, boolean b) {
        if (n>food){
            b=false;
        }else {
            food -= n;
            b=true;
        }
        return b;
    }
    public void addFood(int n){
        food=food+(n-food);
        System.out.println("В тарелку добавили еды.");
    }
    public void info() {
        System.out.println("plate: " + food);
    }

}
