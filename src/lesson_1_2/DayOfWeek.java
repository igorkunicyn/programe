package lesson_1_2;

public enum DayOfWeek {
    MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),
    SATURDAY(6),SUNDAY(7);
    private int number;
    DayOfWeek(int number){
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
    public static void getWorkingHouse(int number) {
        switch (number){
            case 1:
                System.out.println("До конца рабочей недели осталось - 40 часов");
                break;
            case 2:
                System.out.println("До конца рабочей недели осталось - 32 часа");
                break;
            case 3:
                System.out.println("До конца рабочей недели осталось - 24 часа");
                break;
            case 4:
                System.out.println("До конца рабочей недели осталось - 16 часов");
                break;
            case 5:
                System.out.println("До конца рабочей недели осталось - 8 часов");
                break;
            case 6:
                System.out.println("Сегодня - выходной день");
                break;
            case 7:
                System.out.println("Сегодня - выходной день");
                break;
        }
    }
}
