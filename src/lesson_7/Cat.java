package lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety=false;
    }
    public void eat(Plate p, Cat cat) {
        if (p.decreaseFood(appetite,satiety)==false){
            System.out.println("В тарелке недостаточно еды! Кот "+name+" - остался голодный!");
            satiety=false;
            p.addFood(appetite);
            p.info();
            cat.eat(p, cat);
        }else {
            System.out.println("Кот "+name+" - поел!");
            satiety=true;
        }
    }
}
