package lesson_7;

public class TestClass {

    @BeforeSuite
    public void start(){
        System.out.println("Тесты класса "+ TestClass.class.getSimpleName()+" начались");
    }

    @AfterSuite
    public void  end(){
        System.out.println("Тесты класса "+ TestClass.class.getName()+" закончились");
    }
    @Test
    public void testOne(){
        System.out.println("Тест номер 1");
    }
    @Test(5)
    public void testTwo(){
        System.out.println("Тест номер 2");
    }
    @Test(4)
    public void testFree(){
        System.out.println("Тест номер 3");
    }

    @Test(3)
    public void testFour(){
        System.out.println("Тест номер 4");
    }

    @Test(2)
    public void testFive(){
        System.out.println("Тест номер 5");
    }

    @Test
    public void testSix(){
        System.out.println("Тест номер 6");
    }

    @Test(7)
    public void testSeven(){
        System.out.println("Тест номер 7");
    }

    @Test(8)
    public void testEight(){
        System.out.println("Тест номер 8");
    }

    @Test(9)
    public void testNine(){
        System.out.println("Тест номер 9");
    }

    @Test
    public void testTen(){
        System.out.println("Тест номер 10");
    }

}
