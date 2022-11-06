import Homework10.Catcher;

import java.util.Objects;

public class HomeWork10 {
    public static void main(String[] args) {

        /*Написать код, который выбрасывает NullPointerException.
        Написать обработчик этого исключения и вывести на экран сообщение,
        которое будет содержать описание данного исключения.*/
        try {
            exception();
        } catch (NullPointerException e) {
            System.out.println("Task 1 : " + e);
        }

        /*Написать собственное исключение от Exception. Сгенерировать код,
        который будет выбрасывать его и обрабатывать.
        Результат работы программы вывести на экран.
        */
        try {
            throw new Catcher();
        } catch (Catcher e) {
            System.out.println("Task 2 : " + e);
        }
        /*Написать метод, который будет возбуждать исключение и обработать
        это исключение на уровне выше. Результат работы программы вывести на экран.*/
        try {
            task3();
        } catch (Catcher e) {
            System.out.println("Task 3 : " + e);
        }
    }

    public static void exception() {

        Object o = null;

        assert false;
        System.out.println(o.toString());
    }

    public static void task3() throws Catcher {
        String a = "Sity";
        String b = "Long";
        if (Objects.equals(a, b)) {
            System.out.println("Exception");
        } else {
            throw new Catcher();
        }
    }
}
