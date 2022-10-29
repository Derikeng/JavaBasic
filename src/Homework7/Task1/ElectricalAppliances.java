package Homework7.Task1;

public abstract class ElectricalAppliances extends Appliances {
    private static boolean connected;

    public void getConnect() {
        if (connected) {
            System.out.println("Устройство уже подкючено к сети");
        } else {
            connected = true;
            System.out.println("Подключение к сети");
        }
    }
    public void getStarted() {
        if (connected) {
            process();
        } else {
            System.out.println("Устройства не подключены к сети");

        }
    }

    abstract void process();
}
