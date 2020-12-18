package lesson_1;

public class RunningTrack implements Overcomeable {
    static double length;
    static String name;
    RunningTrack(){
        length = 1500;
        name = "RUNNINGTRACK";
    }

    @Override
    public void overcoming(Object o) {
        System.out.println(o+" to running the track");
    }

    @Override
    public void notOvercoming(Object o) {
        System.out.println(o+" could not run the track");
    }
    @Override
    public boolean overOrNotOver(Object o, double d) {
        if (d>=length){
            System.out.println(o+" вышел на беговую дорожку и успешно преодолел ёё.");
            return true;
        }else {
            System.out.println(o+" вышел на беговую дорожку и не смог преодолеть ёё.\n"+o+" сошел с дистанции!");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
