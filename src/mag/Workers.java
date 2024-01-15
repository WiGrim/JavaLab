package mag;

import java.util.Scanner;

public class Workers extends Human implements Cloneable{
    private int pay; // Зарплата сотрудника

    // Конструктор без параметров
    public Workers(){
        this.pay = 0;
    };

    //Конструтор с параметрами
    public Workers(String fname, String lname, int salary) {
        super(fname, lname);
        this.pay = salary;
    }

    // Метод для получения информации о зарплате
    public int getPay() {
        return pay;
    }

    // Метод для установки информации о зарплате
    public void setPay(int pay) {
        this.pay = pay;
    }

    // Метод для ввода информации о сотруднике
    public void inWorker() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя сотрудника: ");
        setFName(scanner.nextLine());

        System.out.print("Введите фамилию сотрудника: ");
        setLName(scanner.nextLine());

        System.out.print("Введите зарплату: ");
        setPay(scanner.nextInt());

    }

    // Метод для вывода информации о сотруднике
    public void outWorker(){
        System.out.print(toString());
    }

    @Override
    public void setAge(float age) {
        this.age = Math.round(age);
    }

    @Override
    public String toString() { //L6 toString
        return "Продавец: " + getFName() + " " + getLName() + "\nЗарплата: " + getPay();
    }

    @Override //Мелкое клонирование
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
