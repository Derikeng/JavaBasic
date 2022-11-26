package Homework12.Thread;

import java.util.stream.IntStream;

public class MaxElement implements Runnable {
    private String Name;

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public void run() {
        int[] numbers = IntStream.range(0, 10).map(i -> (int) (Math.random() * 50)).toArray();
        int max = 0;
        for (int a = 0; a < numbers.length - 1; a++) {
            max = Math.max(max, numbers[a]);
        }
        System.out.println(Name + "  " + max);
    }
}
