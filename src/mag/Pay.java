package mag;

public class Pay<T> {
    private T id;

    public Pay(T id) {
        this.id = id;
    }

    public void PayPrint(String number, int pay){
        System.out.print("Оплата будет произведена с телефона " + number + " на счет " + id + ". Сумма: " + pay);
    }
}
