package mag;

import java.util.Scanner;

public class Product{
    private String ProdName; // Имя товара
    private int cost; // Стоимость товара
    private int count; // Кол-во товара
    private Providers providers; //Ассоциация с классом Providers

    // Конструктор без параметров
    public Product(){
        this.ProdName = "";
        this.cost = 0;
        this.count = 0;
    };

    //Конструтор с параметрами
    public Product(Providers providers, String ProdName, int count, int cost){
        this.providers = providers;
        this.ProdName = ProdName;
        this.count = count;
        this.cost = cost;
    }

    // Метод получения названия товара
    public String getProdName(){
        return ProdName;
    }

    // Метод получения цены товара
    public int getCost(){
        return cost;
    }

    // Метод получения кол-ва товара
    public int getCount(){
        return count;
    }

    // Метод для установки названия товара
    public void setProdName(String ProdName){
       this.ProdName = ProdName;
    }

    // Метод для установки цены товара
    public void setCost(int cost){
        this.cost = cost;
    }

    // Метод для установки кол-ва товара
    public void setCount(int count){
        this.count = count;
    }

    // Метод для ввода информации о товаре
    public void inProduct() {
        Scanner scanner = new Scanner(System.in);

        providers = new Providers() {};

        System.out.print("Введите название поставщика: ");
        providers.setProvName(scanner.nextLine());

        System.out.print("Введите название товара: ");
        setProdName(scanner.nextLine());

        System.out.print("Введите цену товара: ");
        setCost(scanner.nextInt());

        System.out.print("Введите кол-во товара: ");
        setCount(scanner.nextInt());

        providers.Pcount++;
    }

    // Метод для вывода информации о товаре
    public void outProduct(){
        System.out.println("Поставщик: " + providers.getProvName());
        System.out.println("Товар: " + getProdName());
        System.out.println("Цена: " + getCost());
        System.out.println("Кол-во: " + getCount());
    }
}
