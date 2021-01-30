package lesson_1;

public class Orange extends Fruit{
    private float weight;

    Orange() {
        super();
        weight = 1.5f;
    }
    @Override
    float getWeight() {
        return weight;
    }
}
