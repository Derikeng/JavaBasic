import Homework11.Task6.Personality;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork11 {
    public static void main(String[] args) {


        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }
/*Вывести список файлов и каталогов выбранного каталога на диске. Файлы и
каталоги должны быть распечатаны отдельно.*/
    public static void task1() {

        try {
            File file1 = new File("./javaBasic");
            List<String> directories = new ArrayList<>();
            List<String> files = new ArrayList<>();
            File[] listFiles = file1.listFiles();
            if (listFiles == null) {
                System.out.println("Файлы не прочитаны");
            } else {
                for (File file : listFiles) {
                    BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    if (basicFileAttributes.isDirectory()) {
                        directories.add(file.getName());
                    } else if (basicFileAttributes.isRegularFile()) {
                        files.add(file.getName());
                    }
                }
                System.out.println("Directories: " + directories);
                System.out.println("Files: " + files);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/*Создать файл с текстом, прочитать, подсчитать в тексте количество знаков
препинания и слов. Вывести результат на экран.*/
    public static void task2() {
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task2"));
            StringBuilder strBuild = new StringBuilder();
            String line = bufRead.readLine();
            while (line != null) {
                strBuild.append(line);
                line = bufRead.readLine();
            }
            Pattern pattern = Pattern.compile("[.,:;!?]");
            Matcher matcher = pattern.matcher(strBuild.toString());
            System.out.println("Количество знаков препинания " + matcher.results().count());
            Pattern pattern1 = Pattern.compile("\\s*[A-Za-zА-Яа-я0-9'_-]+\\s*");
            Matcher matcher1 = pattern1.matcher(strBuild.toString());
            System.out.println("Количество слов " + matcher1.results().count());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
/*Создать файл с текстом, в котором присутствуют числа. Найти все числа, вывести на
экран, посчитать сумму вывести на экран, убрать все повторяющиеся числа и снова
вывести на экран.
*/
    public static void task3() {
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task3"));
            StringBuilder strBuild = new StringBuilder();
            String line = bufRead.readLine();
            while (line != null) {
                strBuild.append(line);
                strBuild.append("\n");
                line = bufRead.readLine();
            }
            Pattern pattern = Pattern.compile("[0-9]+");
            List<Integer> numbers = new ArrayList<>();
            Matcher matcher = pattern.matcher(strBuild.toString());
            while (matcher.find()) {
                numbers.add(Integer.valueOf(matcher.group()));
            }
            System.out.println(numbers);
            int sum = 0;
            List<Integer> repeatingNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                sum += number;
                if (!repeatingNumbers.contains(number)) {
                    repeatingNumbers.add(number);
                }
            }
            System.out.println(sum);
            System.out.println(repeatingNumbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*Записать с помощью Java в двоичный файл 20 случайных чисел. Прочитать
записанный файл, вывести на экран числа и их среднее арифметическое.*/
    public static void task4() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arr.add((int) (Math.random() * 10 + 1));
            FileOutputStream Task4 = null;
            try {
                Task4 = new FileOutputStream("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task4");
                ObjectOutputStream task4A = new ObjectOutputStream(Task4);
                task4A.writeObject(arr);
                task4A.close();
                FileInputStream task4B = new FileInputStream("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task4");
                ObjectInputStream task4C = new ObjectInputStream(task4B);
                List<Integer> arr1 = (List<Integer>) task4C.readObject();
                System.out.println(arr1);
                int sum = 0;
                for (Integer integer : arr) {
                    sum += integer;
                }
                System.out.println((double) sum / arr1.size());
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
/*Создать цепочку из трех папок. В конечном каталоге создать 5 произвольных
текстовых файлов. Заполнить их 10 случайными целыми числами. Содержимое
файлов записать в один файл в том же каталоге. Создать файл, который будет
содержать список файлов данного каталога.*/
    public static void task5() {
        String[] files = {"first", "first", "second", "third", "fourth", "fifth"};
        try {
            StringBuilder strBuild = new StringBuilder();
            for (String file : files) {
                BufferedReader reader = new BufferedReader(new FileReader("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task5\\" + file));
                String line = reader.readLine();
                while (line != null) {
                    strBuild.append(line);
                    strBuild.append("\n");
                    line = reader.readLine();
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task5\\General"));
            bufferedWriter.write(strBuild.toString());
            bufferedWriter.close();
            File file = new File("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task5");
            String[] list = file.list();
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task5\\List"));
            if (list == null) {
                System.out.println(" Error");
            } else {
                bufferedWriter1.write(String.join("\n", list));
                bufferedWriter1.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*Создать объект Person c полями name, surname, age. Создать два массива (имена и
фамили). Сгенерировать 10 объектов класса Person со случайным age и случайно
выбранными именами и фамилиями соответствующего типа. С помощью Java
создать файл, в который запишется информация о этих людях*/
    public static void task6() {
        String[] name = {"Edward", "Sydney", "Brett", "Theodore", "Charles",
                "Joseph", "Paul", "Leon", "Nathan", "Joel"};
        String[] surname = {"Lester", "Banks", "Lee", "Whitehead", "Carr",
                "Summers", "Dalton", "Parsons", "James", "Blankenship"};
        try {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Personality pers = new Personality();
                pers.setAge((int) (Math.random() * 50));
                pers.setName(name[(int) (Math.random() * name.length)]);
                pers.setSurname(surname[(int) (Math.random() * name.length)]);
                list.add(pers.toString());
            }
BufferedWriter buff=new BufferedWriter(new FileWriter("D:\\IT\\projects\\javaBasic\\src\\Homework11\\Task6\\Pers"));
       buff.write(list.toString());
       buff.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

