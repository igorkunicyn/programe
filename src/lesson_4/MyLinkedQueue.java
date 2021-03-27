package lesson_4;

import java.util.NoSuchElementException;

public class MyLinkedQueue <T>{

    private MyLinkedList<T> ll ;

    public MyLinkedQueue(){
        ll = new MyLinkedList<>();
    }


    public void insert(T item){
        ll.insertFirst(item);
    }
    public T peekFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return ll.getFirst();
    }

    public T remove() {
        return ll.removeLast();
    }



    public boolean isEmpty() {
        return ll.isEmpty();
    }



    @Override
    public String toString() {
        return ll.toString();
    }

}
