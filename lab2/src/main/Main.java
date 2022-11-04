package main;

import Product.product;

import java.util.Scanner;


public class Main {
    /**
     * метод який встановлення найменнування товару
     */
    static void SetProductName(product arr) {
        Scanner in = new Scanner(System.in);

        int n = 0;
        try {
            n = in.nextInt();
        }catch (Exception e) {
            System.out.print("Неправильно введені данні");
        }
        switch (n) {
            case 1 -> arr.setName("Молоко");
            case 2 -> arr.setName("Водяна продукція");
            case 3 -> arr.setName("Хлібна продукція");
            case 4 -> arr.setName("Цукерки");
            case 5 -> arr.setName("Овочі");
            case 6 -> arr.setName("Фрукти");
            case 7 -> arr.setName("алкогольні вироби");
            case 8 -> arr.setName("Тютюнові вироби");
            default -> System.out.print("помилка");
        }
    }
    /**
     * метод встановлення інформації про продукт
     */
       static void SetProduct(product arr) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введіть id продукту ");
            try {
                arr.setid(in.nextInt());
            System.out.print("""
                     1. Молоко\s
                     2. Водяна продукція\s
                     3. Хлібна продукція\s
                     4. Цукерки\s
                     5. Овочі\s
                     6. Фрукти\s
                     7. алкогольні вироби\s
                     8. Тютюнові вироби\s
                    """);

            SetProductName(arr);
            System.out.print("Введіть виробника продукту ");
            arr.setCreator(in.next());
            System.out.print("Введіть ціну продукту ");
            arr.setPrice(in.nextInt());
            System.out.print("Введіть термін продукту дії у днях ");
            arr.setLife(in.nextInt());
            System.out.print("Введіть кількість продукту ");
            arr.setNumber(in.nextInt());
    } catch (Exception e)
            {
        System.out.print("Неправильно введені данні\n");
        return;
    }

    /**
     * Пошук товарів по найменуванню
     * i = counter
     * nb - counter
     * temp - Найменування товару яке шукаємо
     */
    static void ProductOutputByName(product[] arr, int Num)
    {
        Scanner in = new Scanner(System.in);
        int i = 0,nb = 0;
        String temp = null;
        System.out.print("Введіть найменування товару серед цих\n");
        System.out.print(" 1. Молоко \n 2. Водяна продукція \n 3. Хлібна продукція \n 4. Цукерки \n 5. Овочі \n 6. Фрукти \n 7. алкогольні вироби \n 8. Тютюнові вироби \n");
        try{
        temp = in.nextLine();
    }catch (Exception e) {
        System.out.print("Неправильно введені данні");
    }
        for(i=0;i<Num;i++)
        {
        if((arr[i].getName().equals(temp)))
        {
            System.out.print(arr[i].toString());
            nb++;
        }
        }
        if (nb==0)
        {
            System.out.print("Продукту немає\n");
        }
    }
    /**
     * Пошук товарів за ціною
     * i = counter
     * nb - counter
     * temp - ціну яку шукаємо
     */
    static void ProductOutputByPrice(product[] arr, int Num)
    {
        Scanner in = new Scanner(System.in);
        int i = 0, nb = 0;
        System.out.print("Введіть ціну, яку продукти не мають перевищувати ");
        int temp = in.nextInt();
        while (i<Num)
        {
            if(temp >= arr[i].getPrice())
            {
                System.out.print(arr[i].toString());
                nb++;
            }
            i++;
        }
        if (nb==0)
        {
            System.out.print("Продукту немає\n");
        }
    }
    /**
     * Пошук товарів по терміну дії
     * i = counter
     * nb - counter
     * temp - найвище число яке не повинно перевищувати
     */
    static void ProductOutputByLife(product[] arr, int Num)
    {
        Scanner in = new Scanner(System.in);
        int i = 0,nb=0;
        System.out.print("Введіть термін дії у днях, який продукти не мають перевищувати ");
        int temp = in.nextInt();
        while (i<Num)
        {
            if(temp >= arr[i].getLife())
            {
                System.out.print(arr[i].toString());
                nb++;
            }
            i++;
        }
        if (nb==0)
        {
            System.out.print("Продукту немає\n");
        }
    }

    /**
     * Моя функція мейн
     * Num кількість продукту
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        product[] arr = new product[100];
        int Num = 0;
        System.out.print("Введіть кількість товару ");
        try {
        Num = in.nextInt();
    }catch (Exception e) {
        System.out.print("Неправильно введені данні");
        return;
    }
        int i;
        for (i = 0; i < Num; i++) {
            arr[i] = new product();
            SetProduct(arr[i]);
        }
        ProductOutputByName(arr,Num);
        ProductOutputByPrice(arr,Num);
        ProductOutputByLife(arr,Num);
    }
}
