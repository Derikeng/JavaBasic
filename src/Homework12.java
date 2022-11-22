import Homework12.Pools.CallableFiles;
import Homework12.Synchronization.*;
import Homework12.Pools.Thread.Funds;
import Homework12.Pools.Thread.MaxElement;
import Homework12.Pools.Thread.RandomNumb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Homework12 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
    }

    /*Создать 10 потоков, каждый из которых вычисляет среднее арифметическое коллекции
     из 10 случайных целых чисел и выводит на экран.
     */
    public static void task1() {
        IntStream.range(0, 10).mapToObj(i -> new RandomNumb()).forEach(Thread::start);
    }

    /*Создать класс поток, который генерирует массив случайных целых чисел из 10 элементов,
     затем находит максимальный элемент, в этом массиве, и выводит на экран в формате имя потока,
      максимальный элемент. Запустить 10 потоков.
     */
    public static void task2() {
        IntStream.range(0, 10).mapToObj(i -> new MaxElement()).forEachOrdered(maxElement -> {
            Thread thread = new Thread(maxElement);
            maxElement.setName(thread.getName());
            thread.start();
        });
    }

    /*Создать класс поток, который создает средствами Java файл и записать в него произвольно
     сгенерированный массив из 10 случайных целых чисел. Запустить 5 потоков.*/
    public static void task3() {
        IntStream.range(0, 5).mapToObj(i -> new Thread(new Funds())).forEach(Thread::start);
    }

    /*Создать метод, который печатает название потока и засыпает на 2 секунды.
     Запустить одновременно 10 потоков. Реализовать механизм синхронизации,
      чтобы все потоки выполнились последовательно.
     */
    public static void task4() {
        IntStream.range(0, 10).mapToObj(i -> new Thread(new SynMech())).forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }

    /*Создать программу, которая реализует deadlock между тремя потоками.*/
    public static void task5() {
        Locking locking = new Locking();
        Thread thread1 = new Thread(locking);
        Thread thread2 = new Thread(locking);
        Thread thread3 = new Thread(locking);
        thread1.start();
        thread2.start();
        thread3.start();

    }

    /*Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно.
     Есть очередь с 200 элементами. Производители добавляют случайное число от 1..100,
      а потребители берут эти числа. Если в очереди элементов >= 100 производители спят,
       если нет элементов в очереди – потребители спят. Если элементов стало <= 80,
        производители просыпаются. Все это работает до тех пор, пока обработанных
         элементов не станет 10000, только потом программа завершается.
     */
    public static void task6() {
        MainQueue queue = new MainQueue(200);
        Generator generator1 = new Generator(queue);
        Generator generator2 = new Generator(queue);
        Generator generator3 = new Generator(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);
        Thread thread3 = new Thread(generator3);
        Thread thread4 = new Thread(consumer1);
        Thread thread5 = new Thread(consumer2);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

    /*Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными
     строками -> засыпает произвольно на 1-3 секунды, результат
      выполнения – коллекция имен файлов. Запустить 10 задач
      параллельно в пуле из 3 потоков. Вывести ход программы
       на экран с указанием имени потока, который выполняет работу.
     */
    public static void task7() {
        List<String> fileName = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int a = 0; a < 1; a++) {
            Future<List<File>> listFuture = executorService.submit(new CallableFiles());
            try {
                while (!listFuture.isDone()) {
                    Thread.sleep(1);
                }
                for (int b = 0; b < listFuture.get().size(); b++) {
                    fileName.add(listFuture.get().get(b).getName());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        executorService.shutdown();
        System.out.println(fileName);
    }

    /*Создать задачу Callable, которая генерирует коллекцию из 10 рандомных
     целых чисел -> засыпает произвольно на 1-10 секунд, результат
      выполнения – сумму этих чисел в виде строки. Запустить 10 задач
       параллельно в пуле из 3 потоков. Вывести ход программы на экран
        с указанием имени потока, который выполняет работу.*/
    public static void task8() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                List<Integer> numb = new ArrayList<>();
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    numb.add((int) (Math.random() * 10));
                    sum += numb.get(i);
                }
                System.out.println(Thread.currentThread().getName() + " считаем сумму ");
                try {
                    Thread.sleep((int) (Math.random() * 10 - 1) * 1000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return Thread.currentThread().getName() + " Сумма посчитана = " + sum;
            }
        };
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future strfuture = service.submit(callable);
            futureList.add(strfuture);
        }
        while (!futureList.isEmpty()) {
            futureList.forEach(c -> {
                if (c.isDone()) {
                    try {
                        System.out.println(c.get());
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            futureList.removeIf(Future::isDone);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        service.shutdown();
    }

    /*Создать задачу Callable, которая берет сообщение “Hello World”
     + текущее время и записывает его в файл (append = true).
      Запись в файл должна производиться последовательно через синхронизированный метод.
       Запустить 10 задач параллельно в пуле из 3 потоков. Вывести ход программы
        на экран с указанием имени потока, который выполняет работу.
     */
    public static void task9() {
        Callable<File> callable = new Callable<>() {
            @Override
            public synchronized File call() {
                File file = new File("D:\\IT\\projects\\javaBasic\\src\\Homework12\\Pools\\NumberFile");
                try {
                    FileWriter fileWriter = new FileWriter(file, true);
                    Date date = new Date();
                    fileWriter.write("Hello world " + date + "\n");
                    System.out.println(Thread.currentThread().getName());
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return file;
            }
        };
        int thread = 3;
        ExecutorService exser = Executors.newFixedThreadPool(thread);
        for (int a = 0; a < 10; a++) {
            Future<File> fileFuture = exser.submit(callable);
        }
        exser.shutdown();
    }
}
