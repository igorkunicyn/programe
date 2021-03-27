package lesson_4;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("one");
        mll.insertLast("two");
        mll.insertFirst("three");
        mll.insertLast("four");

        System.out.println(mll);




        ListIterator<String> li = mll.listiterator();
        while(li.hasNext()){
            System.out.println(li.next());
        }
//        System.out.println();
//        while(li.hasPrevious()){
//            System.out.println(li.previousIndex());
//            System.out.println(li.previous());
//        }
//        li.add("10");
//        System.out.println(li.next());
//        System.out.println(li.next());
//        System.out.println(li.next());
//        System.out.println(li.next());

////        System.out.println();
        System.out.println();
//                while(li.hasPrevious()){
//            System.out.println(li.previousIndex());
//            System.out.println(li.previous());
//        }

        System.out.println(li.previous());
        System.out.println(li.previous());

        System.out.println(li.previous());
        System.out.println(li.previous());
        li.add("10");

//        li.set("10");

//        li.remove();
        System.out.println();
        ListIterator<String> lin = mll.listiterator();
        while(lin.hasNext()){
                    System.out.println(lin.next());

                }

//        System.out.println(li.hasNext());
//            System.out.println(li.nextIndex());
//        System.out.println(li.next());
//        System.out.println(li.hasNext());
//        System.out.println(li.nextIndex());
//        System.out.println(li.next());

//        }
    }
}
