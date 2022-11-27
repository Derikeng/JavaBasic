import HomeWork13.NewDate;
import HomeWork13.Personality;
import HomeWork13.Logger;
import java.util.Scanner;

public class HomeWork13 {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
    }
/*Создайте простейший сервис с методом, который выводит на экран текущую дату.
 Сделайте его Singleton и используйте в основном теле программы.
 */
    public static void task1() {
        NewDate.getInstance().currentDate();
    }
/*Создайте класс Person с полями: имя, фамилия, год рождения.
 Реализуйте у этого класса паттерн Строитель. Введите поля с клавиатуры
  и заполните объект класса Person с помощью паттерна Строитель.
 */
    public static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter your surname");
        String surname = sc.next();
        System.out.println("Enter your year of birth ");
        Integer year = Integer.parseInt(sc.next());
        Personality person = new Personality.PersonalityBuilder().setName(name).setLastName(surname).setYear(year).build();
        System.out.println(person.toString());
    }
    /*Создайте простейший логгер, выводящий сообщения об ошибках в текстовый файл.
     Объект логгера должен быть создан с помощью ШП Singleton. У объекта должен быть обязательным один метод,
      получающий на вход текст сообщения об ошибке и записывающий его в файл вместе с информацией о дате
       и времени происшествия.
     */
    public static void task3(){
        Logger.getLogger().debug("");
        Logger.getLogger().error("");
        Logger.getLogger().info("");
        Logger.getLogger().warn("");
        Logger.getLogger().fatal("");

    }
}
