package lesson_2_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList( "boy","dog","cat","map","boy","dog","cat","map",
                "flag","key","all","dog","dog","flag","map","all","all","dog","flag"));
        list.add("boy");
        list.add("cat");
        Map<String,Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size() ; i++) {
            String key = list.get(i);
            Integer value = map.getOrDefault(key,0);
            map.put(key,value+1);
        }
        System.out.println(map);
        map.forEach((k,v)->{
            System.out.printf("Слов: %s в массиве: %d\n",k,v);
        });

        TelefonBook telefonBook = new TelefonBook();
        telefonBook.add("Ivanov",8927115554L);
        telefonBook.add("Petrov",8927555544L);
        telefonBook.add("Ivanov",8927533554L);
        telefonBook.add("Nosov",8927556754L);
        telefonBook.add("Sidorov",89999254L);
        telefonBook.get("Ivanov");
        telefonBook.add("Sidorov",898888254L);
        telefonBook.add("Sidorov",897777254L);
        telefonBook.get("Nosov");
        telefonBook.get("Sidorov");
        telefonBook.get("Rysin");
    }
}
