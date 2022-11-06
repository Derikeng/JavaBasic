import HomeWork8.Task1.Seasons;
import HomeWork8.Task4.Car;
import HomeWork8.Task4.Garage;
import HomeWork8.Task4.Moto;

import java.util.Arrays;
import java.util.Scanner;

public class Homework8 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    /*Создать enum, который описывает сезоны года. Добавить поле description в этот enum.
     Добавить поле countOfDays в этот enum. Вывести на экран все константы сезоны года.*/
    public static void task1() {
        Seasons[] seasons = Seasons.values();
        for (Seasons seas : seasons) {
            System.out.println(seas.name() + " " + seas.getDescription() + " - " + seas.getCountOfDays());
        }
    }

    private static Scanner scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    /*Написать метод, который выводит следующий сезон от заданного во входном параметре.
     Входной параметр ввести с клавиатуры.
     */
    public static void task2() {

        Seasons[] seasons = Seasons.values();
        System.out.println("Enter the season " + Arrays.toString(seasons));
        try {
            String name = scan().next();
            Seasons seasons1 = Seasons.valueOf(name);
            if (seasons1.ordinal() < seasons.length - 1) {
                System.out.println(seasons[seasons1.ordinal() + 1]);
            } else {
                System.out.println(seasons[0]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect data entered");
        }
    }

    /*Написать метод, который в зависимости от сезона, выводит на экран сумму дней в этом сезоне.
     Входной параметр ввести с клавиатуры.
     */
    public static void task3() {
        Seasons[] seasons = Seasons.values();
        System.out.println("Enter the season " + Arrays.toString(seasons));
        try {
            String name = scan().next();
            Seasons seasons1 = Seasons.valueOf(name);
            System.out.println("Days in " + seasons1.name() + " = " + seasons1.getCountOfDays());
        } catch (Exception e) {
            System.out.println("Incorrect data entered");
        }
    }

    /*Создать классы Car и Motorcycle, которые наследуются от общего класса Vehicle.
     Создать поле name в классе Vehicle и проинициализировать его через конструктора.
      Создать generic класс Garage, который может хранить только объекты типа наследуемого от Vehicle.
       Создать 2 объекта класса Garage (все поля ввести с клавиатуры) и вывести на экран имя хранимого
       транспортного средства.
     */
    public static void task4() {
        System.out.println("Enter the name of the car");
        String name = scan().next();
        Car auto = new Car(name);
        Garage<Car> garage = new Garage<>(auto);
        System.out.println("Enter the name of the moto");
        Moto moto = new Moto(scan().next());
        Garage<Moto> garage1 = new Garage<>(moto);
        System.out.println("Garage place 1 - " + garage.getVehicleName());
        System.out.println("Garage place 2 - " + garage1.getVehicleName());
    }
}
