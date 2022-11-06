import Homework10.Catcher;

import java.util.Objects;

public class HomeWork10 {
    public static void main(String[] args) {

        /*�������� ���, ������� ����������� NullPointerException.
        �������� ���������� ����� ���������� � ������� �� ����� ���������,
        ������� ����� ��������� �������� ������� ����������.*/
        try {
            exception();
        } catch (NullPointerException e) {
            System.out.println("Task 1 : " + e);
        }

        /*�������� ����������� ���������� �� Exception. ������������� ���,
        ������� ����� ����������� ��� � ������������.
        ��������� ������ ��������� ������� �� �����.
        */
        try {
            throw new Catcher();
        } catch (Catcher e) {
            System.out.println("Task 2 : " + e);
        }
        /*�������� �����, ������� ����� ���������� ���������� � ����������
        ��� ���������� �� ������ ����. ��������� ������ ��������� ������� �� �����.*/
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
