package Homework12.Synchronization;

public class Generator implements Runnable {
    private final MainQueue queue;

    public Generator(MainQueue queue) {
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
            queue.add((int) (Math.random() * 79 + 1));
            System.out.println("Производитель : элементов в очереди : " + queue.getElementsCount());
        }
        System.out.println("Производитель завершил работу." + Thread.currentThread().getName());
    }
}
