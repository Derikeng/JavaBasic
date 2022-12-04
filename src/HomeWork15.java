import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class HomeWork15 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /*Ввести с клавиатуры номер месяца текущего года. Вывести на экран все его даты в формате d::MMM::uuuu.*/
    public static void task1() {
        System.out.println("Enter month numbers");
        Scanner sc = new Scanner(System.in);
        try {
            int month = sc.nextInt();
            if (month > 12 || month < 1) {
                System.out.println("Error");
            }
            LocalDate ld = LocalDate.now();
            LocalDate with = ld.with(ChronoField.MONTH_OF_YEAR, month).with(ChronoField.DAY_OF_MONTH, 1);
            for (int i = 0; i < with.lengthOfMonth() && with.getMonthValue() == month; i++) {

                System.out.println(with.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
                with = with.plusDays(1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*От текущей даты вывести расписание всех встреч, которые происходят еженедельно в 13:00 в течение 2 месяцев.*/
    public static void task2() {
        LocalDateTime startDateTime = LocalDateTime.now().withHour(13).withMinute(0).withSecond(0).withNano(0);
        for (LocalDateTime meet = LocalDateTime.from(startDateTime);
             meet.isBefore(startDateTime.plusMonths(2));
             meet = meet.plus(Period.ofWeeks(1))) {
            System.out.println("Meet 13:00");
            System.out.println(meet.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }

    /*От текущей даты вывести на экран дату, которая была 60 дней назад.*/
    public static void task3() {
        LocalDate ld=LocalDate.now().minusDays(60);
        System.out.println(ld);

    }
}
