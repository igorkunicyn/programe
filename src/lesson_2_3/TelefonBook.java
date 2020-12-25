package lesson_2_3;

import java.util.*;

public class TelefonBook {
    private HashSet<Long> listtelefone;
    private Map<String,HashSet<Long>> map;
    TelefonBook(){
        listtelefone = new HashSet<>();
        map = new HashMap<>();
    }

    void add(String s, Long l){
        if (map.containsKey(s)){
            listtelefone.add(l);
            map.put(s,this.listtelefone);
        }else {
            listtelefone = new HashSet<>();
            listtelefone.add(l);
            map.put(s,listtelefone);
        }
    }
    void get(String s){
        if (map.containsKey(s)){
            System.out.println(s+map.get(s));
        }else System.out.println(s + " has not telefon");
    }
}
