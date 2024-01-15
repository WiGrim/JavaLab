package mag;

public abstract class Providers {
    private String ProvName; // Название поставщика
    static int Pcount = 0; //Кол-во поставщиков

    // Конструктор без параметров
    public Providers(){
        this.ProvName = "";
    };

    //Конструтор с параметрами
    public Providers(String ProvName){
        this.ProvName = ProvName;
    }

    // Метод получения имени поставщика
    public String getProvName(){
        return ProvName;
    }

    // Метод установки имени поставщика
    public void setProvName(String ProvName){
        this.ProvName = ProvName;
    }

    static int getPcount(){
        return Pcount;
    }
}
