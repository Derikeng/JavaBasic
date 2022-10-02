public class Homework2 {
    public static void main(String[] args) {
        task1(198);
        task2(2, 2, 10);
        task2(3, 3, 2);
        task3(241);
        task4(28, 2, 1998);
        task5(2, 2, 3, 3, 6, 6);
        task6(1);
    }

    public static void task1(int pr) {
        boolean b = pr % 10 == 7;
        System.out.println(b);
    }

    public static void task2(int a, int b, int r) {

        System.out.println(Math.sqrt(a * a + b * b) <= r * 2);
    }

    public static void task3(int money) {
        if (money % 10 == 1 && money % 100 != 11) {
            System.out.println(money + " рубль");
        } else if (money % 10 == 2 && money % 100 != 12
                || money % 10 == 3 && money % 100 != 13
                || money % 10 == 4 && money % 100 != 14) {
            System.out.println(money + " рубля");
        } else {
            System.out.println(money + " рублей");
        }
    }

    public static void task4(int day, int month, int year) {
        if (day == 31 && month == 12) {
            System.out.println("1 1 " + (year + 1));
        } else if (day == 31 &&
                (month == 1
                        || month == 3
                        || month == 5
                        || month == 7
                        || month == 8
                        || month == 10)
                || day == 30 &&
                (month == 4
                        || month == 6
                        || month == 9
                        || month == 11)
                || day == 28 && month == 2) {
            System.out.println("1 " + (month + 1) + " " + year);
        } else if (day < 1 || day > 31 || (month == 4
                || month == 6
                || month == 9
                || month == 11) && day > 30 || day > 28 && month == 2) {
            System.out.println("Data entered incorrectly");
        } else {
            System.out.println((day + 1) + " " + month + " " + year);
        }
    }

    public static void task5(float a, float b, float c, float d, float e, float f) {
        System.out.println(a + c <= e && b <= f && d <= f || b + d <= f && a <= e && c <= e);
    }

    public static void task6(int day) {
        switch (day) {
            case 1 -> {
                System.out.println("Задание на понедельник");
                System.out.println("8:00 дз \n9:00 физика");
            }
            case 2 -> System.out.println("Задание на вторник");
            case 3 -> System.out.println("Задание на среду");
            case 4 -> System.out.println("Задание на четверг");
            case 5 -> System.out.println("Задание на пятницу");
            case 6 -> System.out.println("Задание на субботу");
            case 7 -> System.out.println("Задание на воскресенье");
            default -> System.out.println("Дня недели с таким номером не существует");
        }
    }
}