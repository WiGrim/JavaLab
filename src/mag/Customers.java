package mag;

import java.util.Scanner;

public class Customers extends Human implements CallPhone{
    private String pnumber;  // Номер телефона покупателя

    // Конструктор без параметров
    public Customers(){
        this.pnumber = "";
    };

    //Конструтор с параметрами
    public Customers(String fname, String lname, String pnumber){
        super(fname,lname);
        this.pnumber = pnumber;

    }

    // Метод для установки информации о номере телефона
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    // Метод для получения информации о номере телефона
    public String getPnumber() {
        return pnumber;
    }

    // Метод для ввода информации о покупателе
    public void inCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя покупателя: ");
        setFName(scanner.nextLine());

        System.out.print("Введите фамилию покупателя: ");
        setLName(scanner.nextLine());

        System.out.print("Введите номер телефона: ");
        setPnumber(scanner.nextLine());

    }

    // Метод для вывода информации о покупателе
    public void outCustomer() {
        System.out.println("Покупатель:" + fname + " " + lname); //L6 Применение protected
        System.out.println("Номер телефона: " + getPnumber());
    }

    @Override //Перегрузки метода
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public void setAge(float age) {
        this.age = Math.round(age);
    }

    @Override //Интерфейс Call
    public String Call() {
        return pnumber;
    }

    @Override //"Глубокое клонирование"
    protected Object clone() throws CloneNotSupportedException {
        Customers cust = new Customers();
        cust.pnumber = this.pnumber; //Для этих "простых" типов данных подошло бы и обычное клонирование, но принцип для "сложных" такой же
        cust.fname = this.fname;
        cust.lname = this.lname;
        cust.age = this.age;
        return cust;
    }
}
