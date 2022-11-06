package Homework7.Task1;

public abstract class ElectricalAppliances extends Appliances {
    private static boolean connected;

    public void getConnect() {
        if (connected) {
            System.out.println("���������� ��� ��������� � ����");
        } else {
            connected = true;
            System.out.println("����������� � ����");
        }
    }
    public void getStarted() {
        if (connected) {
            process();
        } else {
            System.out.println("���������� �� ���������� � ����");

        }
    }

    abstract void process();
}
