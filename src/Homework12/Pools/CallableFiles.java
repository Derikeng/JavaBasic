package Homework12.Pools;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;


public class CallableFiles implements Callable<List<File>> {
    private final String[] words = {"Algorithm", "Beliberda", "Conceding", "Mashtak",
            "Noisy", "Parable", "Political", "Shared", "Tender", "Their"};

    @Override
    public List<File> call() throws Exception {
        List<File> files = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            File file = new File("D:\\IT\\projects\\javaBasic\\src\\Homework12\\Pools\\"
                    + Thread.currentThread().getName() + "" + a + " "
                    + ThreadLocalRandom.current().nextInt(1000));
            FileWriter fileWriter = new FileWriter("D:\\IT\\projects"
                    + "\\javaBasic\\src\\Homework12\\Pools\\" + " File " + a);
            for (int b = 0; b < 10; b++) {
                fileWriter.write(words[(int) (Math.random() * 10)] + "\n");
            }
            System.out.println(Thread.currentThread().getName() + " Создаем файл " + file.getName());
            files.add(file);
            fileWriter.close();
        }
        Thread.sleep((int) (Math.random() * 3 + 1) * 1000);
        return files;
    }
}
