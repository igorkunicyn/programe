package lesson_2_2;

public class MyArrayDataException extends NumberFormatException{
    private int x;
    private int y;
    MyArrayDataException(int n, int m){
        super();
        x=n;
        y=m;
    }

    @Override
    public String toString() {
        String txt ="Исключение класса MyArrayDataException\n";
        txt+="Элемент массива - строка: "+x+" столбец: "+y+" не содержит числа\n";
        txt+="____________________________________________";
        return txt;
    }

}
