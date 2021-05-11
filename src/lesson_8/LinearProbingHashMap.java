package lesson_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearProbingHashMap<Key, Value> {
    private int capacity;
    private int size;
    private final Object DELETED = -1;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(Key key) {
        return 7 - Math.abs(key.hashCode() % 7);
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put(Key key, Value value){
        if (size > capacity/2){
            ensureCapacity(capacity);
        }
        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);
        while (keys[i] != null && keys[i] != DELETED){
            if(keys[i].equals(key)){
                    i = (i+step) % capacity;
                    key = (Key ) (Object)i;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    private void ensureCapacity(int oldCapacity) {
        List<Integer> list = new ArrayList<>();
        int newCapacity = 2 * oldCapacity;
        for (int i = 2; i <=newCapacity ; i++) {
            list.add(i);
        }
        for (int i = 2; i < list.size() ; i++) {
            for (int j = 2; j < list.size() ; j++) {
                if (list.get(j)% i == 0){
                    list.remove(j);
                }
            }
        }
        capacity = list.get(list.size()-1);
        Key [] keysCopy = Arrays.copyOf(keys, capacity);
        Value [] valuesCopy = Arrays.copyOf(values, capacity);
        keys = keysCopy;
        values = valuesCopy;
    }

    public Value get(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);

        while (keys[i] != null){
            if(keys[i].equals(key)){
                return values[i];
            }
            i = (i+step) % capacity;
        }
        return null;
    }

    public Value delete(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);
        while (keys[i] != null){
            if(keys[i].equals(key)){
                Value value = values[i];
                keys[i] = (Key) DELETED;
                values[i] = null;
                return value;
            }
            i = (i+step) % capacity;
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append(keys[i]).append(" - ");
            sb.append(values[i]).append(" ; ");
            }
        return sb.toString();
    }

}

