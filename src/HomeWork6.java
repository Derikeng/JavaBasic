import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork6 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();

    }

    /*Введите с клавиатуры строку. Найти в строке не только запятые,
     но и другие знаки препинания. Подсчитать общее их количество.
    */
    public static void task1() {
        System.out.println("Enter the string 1");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int before = s.length();
        int after = s.replaceAll("[-,.;:!?<>]", "").length();
        System.out.println("Количество знаков препинания в тексте: " + (before - after));

    }

    /*Введите с клавиатуры текст. Подсчитать количество слов в тексте.
     Учесть, что слова могут разделяться несколькими пробелами,
     в начале и конце текста также могут быть пробелы, но могут и отсутствовать.
     */
    public static void task2() {
        System.out.println("Enter the string 2");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String inputWithoutSpace = s.replace(" ", "");
        int length = inputWithoutSpace.length();
        System.out.println(length);
    }

    /*Введите с клавиатуры текст. Выведите на экран текст,
     составленный из последних букв всех слов из исходного текста.*/
    public static void task3() {
        System.out.println("Enter the string 3");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = s.split(" +");
        for (String word : split) {
            stringBuilder.append(word.charAt(0));
        }
        System.out.println(stringBuilder);

    }

    /*Введите с клавиатуры строку. Напишите метод,
     выполняющий поиск в строке шестнадцатеричных чисел,
      записанных по правилам Java, с помощью регулярных выражений.
      Результат работы метода выведите на экран.*/
    public static void task4() {
        System.out.println("Enter the string 4");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher matcher = Pattern.compile("-?[\\da-fA-F]+").matcher(s);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }

    /*Введите с клавиатуры строку. Напишите метод, выполняющий поиск в строке
     всех тегов абзацев, в том числе тех, у которых есть параметры,
      например, <p id=”p1”>, и замену их на простые теги абзацев <p>.
       Результат работы метода выведите на экран.*/
    public static void task5() {
        System.out.println("Enter the string 5");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String newString = s.replace("\s", "<p>");
        System.out.println(newString);

    }

    /*Напишите два цикла выполняющих миллион сложений строк вида “aaabbbccc”,
     один с помощью оператора сложения и String, а другой с помощью StringBuilder
      и метода append. Сравните скорость их выполнения. Выведите сравнение на экран.
     */
    public static void task6() {
        long time = System.currentTimeMillis();
        StringBuilder strBuilder = new StringBuilder();
        String s = "aaabbbccc";
        for (int n = 1; n < 100000000; n++) {
            s += "aabbbccc";

        }
        System.out.println(s.length());
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();

        for (int i = 1; i < 100000000; i++) {
            strBuilder.append("aaabbbccc");
        }
        System.out.println(strBuilder.length());
        System.out.println(System.currentTimeMillis() - time);
    }
}
