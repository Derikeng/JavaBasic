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

    /*������� � ���������� ������. ����� � ������ �� ������ �������,
     �� � ������ ����� ����������. ���������� ����� �� ����������.
    */
    public static void task1() {
        System.out.println("Enter the string 1");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int before = s.length();
        int after = s.replaceAll("[-,.;:!?<>]", "").length();
        System.out.println("���������� ������ ���������� � ������: " + (before - after));

    }

    /*������� � ���������� �����. ���������� ���������� ���� � ������.
     ������, ��� ����� ����� ����������� ����������� ���������,
     � ������ � ����� ������ ����� ����� ���� �������, �� ����� � �������������.
     */
    public static void task2() {
        System.out.println("Enter the string 2");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String inputWithoutSpace = s.replace(" ", "");
        int length = inputWithoutSpace.length();
        System.out.println(length);
    }

    /*������� � ���������� �����. �������� �� ����� �����,
     ������������ �� ��������� ���� ���� ���� �� ��������� ������.*/
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

    /*������� � ���������� ������. �������� �����,
     ����������� ����� � ������ ����������������� �����,
      ���������� �� �������� Java, � ������� ���������� ���������.
      ��������� ������ ������ �������� �� �����.*/
    public static void task4() {
        System.out.println("Enter the string 4");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher matcher = Pattern.compile("-?[\\da-fA-F]+").matcher(s);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }

    /*������� � ���������� ������. �������� �����, ����������� ����� � ������
     ���� ����� �������, � ��� ����� ���, � ������� ���� ���������,
      ��������, <p id=�p1�>, � ������ �� �� ������� ���� ������� <p>.
       ��������� ������ ������ �������� �� �����.*/
    public static void task5() {
        System.out.println("Enter the string 5");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String newString = s.replace("\s", "<p>");
        System.out.println(newString);

    }

    /*�������� ��� ����� ����������� ������� �������� ����� ���� �aaabbbccc�,
     ���� � ������� ��������� �������� � String, � ������ � ������� StringBuilder
      � ������ append. �������� �������� �� ����������. �������� ��������� �� �����.
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
