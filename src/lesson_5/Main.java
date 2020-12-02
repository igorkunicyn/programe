package lesson_5;

public class Main {

    public static void main(String [] args){
        Employee [] employee= new Employee[5];
        employee[0]= new Employee("Ivanov Ivan Ivanovich", "Meneger","iivan@mail.ru", "8927123456", 50000, 35);
        employee[1]= new Employee("Andreev Andrey Andreevich","Economist","aandrey@mail.ru", "8927123457", 45000, 42);
        employee[2]= new Employee("Sergeev Sergey Sergeevich", "Enginer", "ssergey@mail.ru", "8927123458", 45000, 48);
        employee[3]= new Employee("Petrov Petr Petrovich", "Working", "ppetr@mail.ru", "8927123459", 30000, 35);
        employee[4]= new Employee("Glebov Gleb Glebovich", "Director", "ggleb@mail.ry", "8927897456", 65000,51);
        for (int i = 0; i < employee.length ; i++) {
            if (employee[i].age>40) {
                employee[i].getPrintEmployee();
            }
        }
    }

}

class Employee{
    String surnameandname;
    String post;
    String email;
    String telefon;
    int salery;
    int age;
    Employee(String surnameandname, String post, String email, String telefon, int salery, int age){
        this.surnameandname=surnameandname;
        this.post= post;
        this.email= email;
        this.telefon= telefon;
        this.salery = salery;
        this.age = age;
    }
    void getPrintEmployee(){
        System.out.printf("Emloyee: %s %s %s %s %d %d\n", surnameandname, post,email,telefon, salery, age);
    }
}
