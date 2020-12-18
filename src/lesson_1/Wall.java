package lesson_1;

public class Wall implements Overcomeable{
    static double height;
    static String name;
    Wall(){
        height = 2;
        name= "WALL";
    }

    @Override
    public void overcoming(Object o) {
        System.out.println(o+" to climb over the wall");
    }

    @Override
    public void notOvercoming(Object o) {
        System.out.println(o+" could not get over the wall");
    }

    @Override
    public boolean overOrNotOver(Object o, double d) {
        if (d>=height){
            System.out.println(o+" достиг стены и успешно преодолел ёё!");
            return true;
        }else {
            System.out.println(o+" достиг стены и не смог преодолеть ёё.\n"+o+" сошел с дистанции!");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
