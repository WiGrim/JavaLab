package mag;
public abstract class Human {
    protected String fname; // Имя человека
    protected String lname; // Фамилия человека

    protected int age;

    // Конструктор без параметров
    public Human(){
        this.fname = "";
        this.lname = "";
    };

    //Конструтор с параметрами
    public Human(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    // Метод получения имени человека
    public String getFName(){
        return fname;
    }

    // Метод получения фамилии человека
    public String getLName() {
        return lname;
    }

    // Метод установки имени человека
    public void setFName(String fname){
        this.fname = fname;
    }
    // Метод установки фамилии человека
    public void setLName(String lname){
        this.lname = lname;
    }

    public void setAge(int age) { this.age = age; }
    // Метод установки фамилии человека
    public int getAge() { return age;}

    public abstract void setAge(float age);
}
