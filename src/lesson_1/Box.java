package lesson_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> box;

    Box() {
        box = new ArrayList<>();
    }

    void addToBox(T... t){
        Collections.addAll(box, t);
    }

    List<T> getBox() {
        return box;
    }
    float getWeight(){
        float sum = 0.0f;
        for (T t : box) {
            sum += t.getWeight();
        }
        return sum;
    }

    boolean compare(Box o) {
        if (!(Math.abs(this.getWeight() - o.getWeight()) < 0.00001)) {
            return false;
        }
        return true;
    }

    void moving(Box<T> t){
        this.getBox().addAll(t.getBox());
        t.getBox().clear();

    }
}
