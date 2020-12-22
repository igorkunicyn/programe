package lesson_2_2;

public class Main {
    public static void main(String[] args) {
        String [][] strings = {{"12","10","8","123"},{"14","1","52","75"},
                {"4","145","1025","58"},{"410","458","13","99"}};
        String [][] strings1 = {{"12","10","8","123"},{"14","1","52","75"},
                {"23","145","22","58"},{"","458","13","99"}};
        String [][] strings2 = {{"12","10","55","41"},{"14","1","52","75"},
                {"4","145","58"}, {"410","458","13","99"}};
        String [][] strings3 = {{"12","10","8","123"},{"14","1","52","75"},
                {"23","145","rtt","58"},{"35","458","13","99"}};
        int size= 4;
        try{
            processArray(strings2,size);
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }catch (NumberFormatException g){
            g.printStackTrace();
        }
        System.out.println("END");

    }
    public static void processArray(String [][]s, int size)throws MyArraySizeException,MyArrayDataException,NumberFormatException{
        if (s.length!=size){
            throw new MyArraySizeException(s.length);
        }else {
            for (int i = 0; i <s.length ; i++) {
                if (s[i].length!=size){
                    throw new MyArraySizeException(s[i].length,i);
                }
            }
        }
        int summ=0;
        for (int i = 0; i <s.length ; i++) {
            for (int j = 0; j < s[i].length; j++) {
                String string = s[i][j];
                for (int k = 0; k < string.length(); k++) {
                    char symbol= string.charAt(k);
                    if (symbol<'0'||symbol>'9'){
                        throw new MyArrayDataException(i,j);
                    }
                }
                summ += Integer.parseInt(s[i][j]);
            }
        }
        System.out.println(summ);
    }
}
