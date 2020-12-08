package ru.geekbrains.spring.context;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        boolean isTrue = true;
        intro();
        Cart cart = context.getBean("cart", Cart.class);
        System.out.println(cart.show() + "\n");

        Scanner scanner = new Scanner(System.in);
        while (isTrue) {
            String cmd = scanner.nextLine();
            if (cmd.equals("0")) {
                System.out.println(cart.show() + "\n");
                intro();
            } else if (cmd.equals("1")) {
                System.out.println("Введите ID товара (первое поле класса Product: 1,2,3,4,5)");
                int id = scanner.nextInt();
                System.out.println(cart.getProductById(id));
                intro();
            } else if (cmd.equals("2")) {
                System.out.println("Введите подряд 3 характеристики товара ID, String Title, Int cost");
                int id = scanner.nextInt();
                String title = scanner.next();
                int cost = scanner.nextInt();
                cart.add(new Product(id, title, cost));

                System.out.println("Обновленная корзина");
                System.out.println(cart.show() + "\n");
                intro();
            } else if (cmd.equals("3")) {
                System.out.println("Введите НОМЕР товара 1,2,3,4,5");
                int id = scanner.nextInt();
                cart.remove(id);
                System.out.println("Обновленная корзина:");
                System.out.println(cart.show());
                intro();
            }

        }

//
//        cart.add(new Product(7, "test", 700));
//
//        System.out.println(cart.show());
//
//        cart.remove(1);
//
//        System.out.println(cart.show());
//
//
//        System.out.println(cart.calculateTotalPrice());


        context.close();
    }

    public static void intro(){
        System.out.println("    Проверка на неверный ввод есть только в \"Показать или Удалить товар по ID\", пожалуйста, вводите аккуратнее.");
        System.out.println("    Программма бесконечная. Перезапускать когда хочется.");
        System.out.println("Показать всю корзину - нажмите 0");
        System.out.println("Показать товар по ID - нажмите 1");
        System.out.println("Добавить товар - нажмите 2");
        System.out.println("Удалить товар - нажмите 3\n");
        System.out.println("Сейчас в корзине:");
    }
}
