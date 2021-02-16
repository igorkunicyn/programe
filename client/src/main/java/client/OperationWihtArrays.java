package client;

import java.util.ArrayList;
import java.util.List;

public class OperationWihtArrays {
    public int[] newArray(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int i = array.length-1; i >= 0 ; i--) {
            if (array[i] != 4){
                list.add(array[i]);
            }else {
                break;
            }

        }
        int [] arrayRezult = new int[list.size()];
        for (int i = 0; i <arrayRezult.length ; i++) {
            arrayRezult[i] = list.get(list.size()-1-i);
        }
            if (array.length == arrayRezult.length){
                throw new RuntimeException("Массив не содержит цифру 4 ");
            }
        return arrayRezult;
    }

    public boolean oneFourArray(int [] array){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <array.length; i++) {
            if (array[i] == 1 || array [i] == 4){
                list.add(array[i]);
            }else {
                return false;
            }
        }
        if (!list.contains(1) || !list.contains(4)) return false;
        return true;
    }


}
