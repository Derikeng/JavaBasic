package Homework12.Synchronization;

public class Consumer implements Runnable {
    private final MainQueue queue;

    public Consumer(MainQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.getCount() < 10000) {
            try {
                Thread.sleep((int) (Math.random() * 999 + 1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (queue.getElementsCount() > 80) {
                queue.remove();
                System.out.println("Потребитель : элементов в очеред : " + queue.getElementsCount()
                        + " (Обработаных элементов = " + queue.getCount() + ")");
            }
        }
        System.out.println("Потребитель завершил работу." + Thread.currentThread().getName());
    }
}
