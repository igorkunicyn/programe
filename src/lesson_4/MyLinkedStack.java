package lesson_4;

import lesson_3.MyStack;

public class MyLinkedStack<T> {
    private MyLinkedList<T> ll ;

    public MyLinkedStack(){
        ll = new MyLinkedList<>();
    }

    public void push(T item) {
        ll.insertFirst(item);
    }

    public T peek(){
        return ll.getFirst();
    }

    public T pop(){
        return ll.removeFirst();
    }

    public int size(){
        return ll.size();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }
    @Override
    public String toString() {
        return ll.toString();
//        StringBuilder sb = new StringBuilder("[ ");
//        for (int i = 0; i < ll.size() ; i++) {
//            sb.append(ll.).append(", ");
//        }
//        if (size > 0) {
//            sb.setLength(sb.length() - 2);
//        }
//        sb.append(" ]");
//        return sb.toString();
    }

}
