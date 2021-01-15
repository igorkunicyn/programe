package lesson_2_4;


public class MyClass implements Runnable{
    private String name;
    private float [] arr;
    private Thread t;
    MyClass(String name, float [] arr) {
        this.name= name;
        this.arr= arr;
        t = new Thread(this,name);
//        System.out.println("Новый поток: "+t);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        long a, b;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
        }
//        System.out.println("Поток "+name+" завершен.");
    }

    float [] getArr(){
        return arr;
    }
}
