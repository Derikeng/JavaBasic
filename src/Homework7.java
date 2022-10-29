import Homework7.Task1.ElectricalAppliances;
import Homework7.Task1.Freezer;
import Homework7.Task1.Microwave;
import Homework7.Task1.Television;
import Homework7.Task2.*;
import Homework7.Task3.*;

public class Homework7 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /*Создать цепочку наследования (минимум 3 звена) классов, описывающих бытовую технику.
     Создать несколько объектов описанных классов, часть из них включить в розетку.
     Иерархия должна иметь хотя бы три уровня.*/
    public static void task1() {
        Microwave microwave = new Microwave();
        Freezer freezer = new Freezer();
        Television television = new Television();
        System.out.println("---------------TASK 1---------------");
        System.out.println("Начинаем работу ");

        microwave.getStarted();
        microwave.getConnect();
        microwave.process();

        freezer.getStarted();
        freezer.getConnect();

        television.getStarted();
        television.getConnect();
        System.out.println();
    }

    /*Создать цепочку наследования (минимум 3 звена) классов, описывающих банковские карточки.
     Иерархия должна иметь хотя бы три уровня.*/
    public static void task2() {
        System.out.println("---------------TASK 2---------------");
        BankCard[] bankCards = new BankCard[]{
                new DepositBelApb(), new PensionBelApb(), new DepositBVB(),
                new PensionBVB(), new DepositMaestro(), new PensionMaestro(), new BVB(), new BelApb(), new Maestro()
        };
        for (BankCard bankCard : bankCards) {
            System.out.println(bankCard.GetName());
        }
        System.out.println();
    }

    /*Создать цепочку наследования (минимум 3 звена) классов, описывающих должностную структуру на заводе.
     Реализовать методы по начислению зарплаты в зависимости от должности (почасовая, процентная, смешанная).
      Иерархия должна иметь хотя бы три уровня.
     */
    public static void task3() {
        System.out.println("---------------TASK 3---------------");
        Director[] directors = new Director[]{
                new Director(), new ChiefEngineer(), new MechanicalEngineer(),
                new ChiefMechanical(), new Mechanical(), new TraineeMechanic()
        };
        for (Director director : directors) {
            System.out.println(director.getClass().getName() + ": " + director.wage());

        }
    }
}

