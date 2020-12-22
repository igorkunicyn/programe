package lesson_2_2;

public class MyArraySizeException extends IllegalArgumentException{
    private int length;
    private int number;
    private int var;
    MyArraySizeException(int n){
        super();
        length=n;
        var=1;
    }
    MyArraySizeException(int n, int m){
        super();
        length=n;
        number=m;
        var=2;
    }
    @Override
    public String toString() {
        String txt ="Исключение класса MyArraySizeException\n";
        if(var==1) {
            txt += "Неправильный размер массива. Неверное число строк: " + length + "\n";
            txt += "____________________________________________";
        }else if (var==2){
            txt+="Неверное число элементов: "+length+" в строке: "+number+"\n";
            txt+="____________________________________________";
        }
        return txt;
    }

}
