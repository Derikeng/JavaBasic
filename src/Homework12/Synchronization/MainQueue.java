package Homework12.Synchronization;

public class MainQueue {
    private int undertaking;
    private int completion;


    private volatile int elementsCount;
    private Integer[] ArrayQueue;
    private Integer count = 0;

    public MainQueue(int size) {
        ArrayQueue = new Integer[size];
    }

    public Integer getCount() {
        return count;
    }


    public void add(Integer element) {
        synchronized (this) {
            while (elementsCount >= 100) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            ArrayQueue[undertaking] = element;
            elementsCount++;
            if (undertaking == ArrayQueue.length - 1) {
                undertaking = 0;

            } else {
                undertaking++;
            }
            this.notifyAll();
        }
    }

    public void remove() {
        synchronized (this) {
            while (getElementsCount() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Integer value = ArrayQueue[completion];
            ArrayQueue[completion] = null;
            elementsCount--;
            if (completion == ArrayQueue.length - 1) {
                completion = 0;
            } else {
                completion++;
            }
            count++;
            if (elementsCount <= 80) {
                notifyAll();
            }
        }
    }

    public synchronized int getElementsCount() {
        return elementsCount;
    }
}
