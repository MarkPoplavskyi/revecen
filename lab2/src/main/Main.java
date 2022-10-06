package main;

import Product.product;

import java.util.Scanner;


public class Main {
    /**
     * метод який виводить на екран найменнування товару
     */
    static void SetProductName(product arr) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

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
     * метод встановлення інформаціїї про продукт
     */
    static void SetProduct(product arr) {

            Scanner in = new Scanner(System.in);
            System.out.print("Введіть id продукта ");
            arr.setid(in.nextInt());
            System.out.print(" 1. Молоко \n 2. Водяна продукція \n 3. Хлібна продукція \n 4. Цукерки \n 5. Овочі \n 6. Фрукти \n 7. алкогольні вироби \n 8. Тютюнові вироби \n");
            SetProductName(arr);
            System.out.print("Введіть виробника продукта ");
            arr.setCreator(in.next());
            System.out.print("Введіть ціну продукта ");
            arr.setPrice(in.nextInt());
            System.out.print("Введіть термін продукта дії у днях ");
            arr.setLife(in.nextInt());
            System.out.print("Введіть кількість продукту ");
            arr.setNumber(in.nextInt());
        }

    /**
     * Пошук товарів по найменуванню
     */
    static void ProductOutputByName(product[] arr, int Num)
    {
        Scanner in = new Scanner(System.in);
        int i = 0,nb = 0;
        System.out.print("Введіть найменування товару серед цих\n");
        System.out.print(" 1. Молоко \n 2. Водяна продукція \n 3. Хлібна продукція \n 4. Цукерки \n 5. Овочі \n 6. Фрукти \n 7. алкогольні вироби \n 8. Тютюнові вироби \n");
        String temp = in.nextLine();
        while (i<Num)
        {
        if((arr[i].getName().equals(temp)))
        {
            arr[i].PrintValue();
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
     * Пошук товарів по ціні
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
                arr[i].PrintValue();
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
                arr[i].PrintValue();
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
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        product[] arr = new product[100];
        System.out.print("Введіть кількість товару ");
        int Num = in.nextInt();
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




