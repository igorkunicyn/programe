package lesson_3;

import java.util.NoSuchElementException;

public class MyQueue <T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;


    public MyQueue(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insert(T item){
        if (isFull()) {
            extensionArray();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);

    }
// расширение массива
    public void extensionArray(){
        int newCapacity = capacity * 2;
        capacity = newCapacity;
        T[] tempArr = (T[]) new Object[capacity];
        System.arraycopy(list, begin, tempArr, 0, list.length-begin);
        System.arraycopy(list, 0, tempArr, list.length-begin, end);
        begin = 0;
        end = size;
        list = tempArr;
    }

    public T peekFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T remove() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        if (begin == end){
            for (int i = begin; i <list.length ; i++) {
                sb.append(list[i]).append(", ");
            }
            for (int i = 0; i <end ; i++) {
                sb.append(list[i]).append(", ");
            }

        }else{
            int i = begin;
            while (i != end) {
                sb.append(list[i]).append(", ");
                i = nextIndex(i);
            }

        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }

}
