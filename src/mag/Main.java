package mag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void test (int n) {
        if (n < 1 || n > 2){
            throw new RuntimeException("Некорректный вибор типа сотрудника");
        }
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Customers[][] cust = new Customers[2][5]; //двухмерный массив обьектов класса
            Workers[] work = new Workers[5];
            Product[] prod = new Product[5];
            IntCounter intcount = new IntCounter();
            ArrayList<Workers> arrwork = new ArrayList<Workers>();

            int c, c1 = 0, c2 = 0, c3 = 0, counterC1 = 0, counterC2 = 0, counterW = 0, counterP = 0, c4;
            do //1 ур. меню
            {
                String s1 = "\n1 Ввод покупателя"; //Строка
                System.out.println(s1);
                System.out.println("2 Ввод работника");
                System.out.println("3 Ввод товаров");
                System.out.println("4 Составление чека");
                System.out.println("5 Сводка работников");
                System.out.println("6 Выход");
                do
                {
                    c = scanner.nextInt();
                    if (c < 1 || c > 6)
                        System.out.println("Ошибка. Введите корректный пункт списка.");
                } while (c < 1 || c > 6);//Проверка ввода c
                switch (c)
                {
                    case 1:
                        System.out.println("Выберите тип покупателя:");
                        System.out.println("1 Обычный");
                        System.out.println("2 VIP");
                        c = scanner.nextInt();
                        try {
                            test(c); //Исключение для неверного номера списка
                            if (c == 1){
                                cust[c - 1][counterC1] = new Customers();
                                cust[c - 1][counterC1].inCustomer();
                                counterC1 += 1;
                            }
                            else {
                                cust[c - 1][counterC2] = new Customers();
                                cust[c - 1][counterC2].inCustomer();
                                counterC2 += 1;
                            }
                            c1 = 1;
                        }
                        catch (RuntimeException a) {
                            System.out.println(a.getMessage());
                        }
                        break;
                    case 2:
                        work[counterW] = new Workers();
                        work[counterW].inWorker();
                        c2 = 1;
                        counterW += 1;
                        break;
                    case 3:
                        System.out.println("Введите кол-во товаров: (max 5)");
                        counterP = scanner.nextInt();
                        for (int i = 0; i < counterP; ++i)
                        {
                            prod[i] = new Product();
                            prod[i].inProduct();
                        }
                        System.out.println("Количество поставщиков товаров: " + Providers.getPcount()); //Вывод кол-ва поставщиков
                        c3 = 1;
                        break;
                    case 4:
                        if (c1 == 1 & c2 == 1 & c3 == 1)
                        {
                            System.out.println("Выберите тип покупателя:");
                            System.out.println("1 Обычный");
                            System.out.println("2 VIP");
                            do
                            {
                                c = scanner.nextInt();
                                if (c < 1 || c > 2)
                                    System.out.println("Ошибка. Введите корректный пункт списка.");
                            } while (c < 1 || c > 2);
                            System.out.println("Выберите покупателя:");
                            if (c == 1){
                                for (int i = 0; i < counterC1; ++i){
                                    System.out.println(i + 1);
                                    cust[c - 1][i].outCustomer();
                                }
                            }
                            else {
                                for (int i = 0; i < counterC2; ++i){
                                    System.out.println(i + 1);
                                    cust[c - 1][i].outCustomer();
                                }
                            }
                            int curCust = scanner.nextInt() - 1;
                            System.out.println("Выберите продавца:");
                            for (int i = 0; i < counterW; ++i){
                                System.out.println(i + 1);
                                work[i].outWorker();
                            }
                            int curWork = scanner.nextInt() - 1;
                            System.out.println("Выберите товары:");
                            int i;
                            for (i = 0; i < counterP; ++i){
                                System.out.println(i + 1);
                                prod[i].outProduct();
                            }
                            System.out.println(i + 1);
                            System.out.println("Составить чек");
                            int j = 0;
                            int[] pstk;
                            pstk = new int[5];
                            do {
                                c4 = scanner.nextInt();
                                if (c4 < 1 || c4 > i + 2)
                                    System.out.println("Ошибка. Введите корректный пункт списка.");
                                else if (c4 != i + 1){
                                    pstk[j] = c4 - 1;
                                    ++j;
                                }
                            }while (c4 != i + 1);

                            cust[c - 1][curCust].outCustomer();
                            work[curWork].outWorker();
                            System.out.println("\nТовары:");
                            for (i = 0; i < j; ++i) {
                                System.out.println(prod[pstk[i]].getProdName());
                            }
                            System.out.println("Сумма:");
                            int sum = 0;
                            for (i = 0; i < j; ++i) {
                                sum = intcount.Summ(sum, prod[pstk[i]].getCost()); //Возврат целочисленного значения через вспомогательный класс
                            }
                            System.out.println(sum);
                            System.out.println("По умолчанию для оплаты используется счет привязанный к этому номеру телефона: " + cust[c - 1][curCust].Call());
                            Pay<Integer> pay = new Pay<Integer>(1234); //L6 Шаблон класса
                            pay.PayPrint(cust[c - 1][curCust].Call(), sum);
                        }
                        else
                        {
                            System.out.println("Ошибка. Не все поля заполнены.");
                            if (c1 == 0)
                            {
                                System.out.println("Покупатель не заполнен");
                            }
                            if (c2 == 0)
                            {
                                System.out.println("Продавец не заполнен");
                            }
                            if (c3 == 0)
                            {
                                System.out.println("Товары не заполнены");
                            }
                        }
                        break;
                    case 5:
                        for (int i = 0; i < counterW; ++i){
                            arrwork.add(work[i]);
                        }
                        System.out.println("Существуюшие зарплаты:");
                        for(Workers s : arrwork) {
                            System.out.println(s.getPay());
                        }
                        arrwork.sort(new Comparator<Workers>() { //Сортировка
                            @Override
                            public int compare(Workers o1, Workers o2) {
                                if (o1.getPay() == o2.getPay()) return 0;
                                else if (o1.getPay()> o2.getPay()) return 1;
                                else return -1;
                            }
                        });
                        System.out.println("Отсортированные:");
                        for(Workers s : arrwork) {
                            System.out.println(s.getPay());
                        }
                        System.out.println("Найти роботника по фамилии? (1- да, 0 - нет)"); //Поиск по фамилии
                        c = scanner.nextInt();
                        if (c == 1){
                            System.out.println("Введите фамилию");
                            String ln = scanner.nextLine(); //что бы убрать \n из ввода
                            ln = scanner.nextLine();
                            for(Workers s : arrwork) {
                                if (s.getLName().equals(ln)){
                                    System.out.println(s.getFName());
                                    System.out.println(s.getLName());
                                    System.out.println(s.getPay());
                                    c = 0;
                                }
                            }
                            if (c != 0){
                                System.out.println("Работники не найдены");
                            }
                        }
                        break;
                    case 6:
                        break;
                    default: System.out.println("Ошибка. Некорректная переменная ввода. >>> c in main");
                        break;
                }
            } while (c != 6);
        }
    }