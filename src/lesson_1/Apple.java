package lesson_1;

public class Apple extends Fruit{

    private float weight;

    Apple() {
        super();
        this.weight = 1.0f;
    }
    @Override
    float getWeight() {
        return weight;
    }
}
