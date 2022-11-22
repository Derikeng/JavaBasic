package Homework12.Thread;

import java.util.ArrayList;
import java.util.List;

public class RandomNumb extends Thread {
    public void run() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add((int) (Math.random() * 50));

        }
        int sum = 0;
        for (Integer integer : integerList) {
            sum += integer;

        }
        System.out.println((double) sum / integerList.size());
    }

}
