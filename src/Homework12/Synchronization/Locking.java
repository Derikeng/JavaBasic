package Homework12.Synchronization;

public class Locking implements Runnable {

    public void path1() {
        synchronized (String.class) {
            System.out.println("Lock  String.class");
            synchronized (Integer.class) {
                System.out.println("Lock   Integer.class");
                synchronized (Double.class) {
                    System.out.println("Lock   Double.class");
                }
            }
        }
    }

    public void path2() {
        synchronized (Integer.class) {
            System.out.println("Lock   Integer.class");
            synchronized (Double.class) {
                System.out.println("Lock   Double.class");
                synchronized (String.class) {
                    System.out.println("Lock  String.class");

                }
            }
        }
    }

    public void path3() {
        synchronized (Double.class) {
            System.out.println("Lock   Double.class");
            synchronized (String.class) {
                System.out.println("Lock  String.class");
                synchronized (Integer.class) {
                    System.out.println("Lock   Integer.class");
                }
            }
        }
    }

    @Override
    public void run() {
        path1();
        path2();
        path3();

    }
}
