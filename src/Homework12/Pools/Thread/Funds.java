package Homework12.Pools.Thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Funds implements Runnable {

    @Override
    public void run() {
        int[] numbers = IntStream.range(0, 10).map(i -> (int) (Math.random() * 50)).toArray();
        try {
            FileWriter numb = new FileWriter("D:\\IT\\projects\\javaBasic\\src\\Homework12\\Thread\\Arrays");
            BufferedWriter bufferedWriter = new BufferedWriter(numb);
       bufferedWriter.write(Arrays.toString(numbers));
       bufferedWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
