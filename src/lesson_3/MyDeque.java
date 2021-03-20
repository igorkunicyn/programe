package lesson_3;


import java.util.NoSuchElementException;

public class MyDeque <T>{
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;


    public MyDeque(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insertLeft(T item) throws IllegalStateException {
        if (isFull()) {
            extensionArray(1);
        }
        list[begin] = item;
        if (--begin < 0) begin = list.length-1;
        size++;
//        end = nextIndex(end);
    }
    public void insertRight(T item) throws IllegalStateException {
        if (isFull()) {
            extensionArray(0);
        }
        if (++end == list.length) end = 0;
        list[end] = item;
        size++;

//        end = nextIndex(end);
    }
//    расширение массива
    public void extensionArray(int index){
        int newCapacity = capacity * 2;
        capacity = newCapacity;
        T[] tempArr = (T[]) new Object[capacity];
        int startIndex = index;
        for (int i = begin+1; i < list.length ; i++) {
            tempArr[startIndex] = list[i];
            startIndex++;
        }
        for (int i = 0; i <= end ; i++) {
            tempArr[startIndex] = list[i];
            startIndex++;
        }
        begin = 0;
        end = size-(1-index);
        list = tempArr;
    }

    public T peekLeft() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return list[begin];
    }
    public T peekRight() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return list[end];
    }

    public T removeLeft() throws NoSuchElementException {
        if (++begin == list.length) {
            begin= 0;
        }
        T temp = peekLeft();
        list[begin] = null;
//        begin = nextIndex(begin);
        size--;
        return temp;
    }
    public T removeRight() {
        T temp = peekRight();
        list[end] = null;
        if (--end < 0) {
            end = list.length-1;
        }
        size--;
//        begin = nextIndex(begin);
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
        if (isEmpty()){
            return " ";
        }
        StringBuilder sb = new StringBuilder("[ ");
        if (begin == end){
            for (int i = begin+1; i <list.length ; i++) {
                sb.append(list[i]).append(", ");
            }
            for (int i = 0; i <end+1 ; i++) {
                sb.append(list[i]).append(", ");
            }

        }else{
            int i = begin;
            while (i != end) {
                i = nextIndex(i);
                sb.append(list[i]).append(", ");
            }

        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }

}
