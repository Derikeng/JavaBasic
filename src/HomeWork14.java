import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class HomeWork14 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        double sum = IntStream.range(0, 30)
                .filter(intValue -> intValue < 20)
                .filter(intValue -> intValue % 2 == 0)
                .mapToDouble(a -> a)
                .peek((e) -> System.out.println(e + " inch = "))
                .peek((c) -> System.out.println(c * 2.54 + " cm "))
                .map((c) -> c * 2.54).sum();
        System.out.println(sum + "cm");
    }

    public static void task2() {
        try {
            List<String> list = new ArrayList<>();
            BufferedReader buffRead1 = new BufferedReader(new FileReader("D:\\IT\\projects\\javaBasic\\src\\Names.txt"));
            String line;
            while ((line = buffRead1.readLine()) != null) {
                list.add(line);
            }
            List<String> surnameList = new ArrayList<>();
            BufferedReader buffRead2 = new BufferedReader(new FileReader("D:\\IT\\projects\\javaBasic\\src\\Surnames.txt"));
            while ((line = buffRead2.readLine()) != null) {
                surnameList.add(line);
            }
            List<String> people = IntStream.range(0, 100).mapToObj(i -> {
                        Personality person = new Personality();
                        person.setName(list.get((int) (Math.random() * 100)));
                        person.setSurName(surnameList.get((int) (Math.random() * 100)));
                        person.setAge((int) (Math.random() * 15 + 15));
                        return person;
                    })
                    .filter(p -> p.getAge() < 21)
                    .peek(System.out::println)
                    .sorted(Comparator.comparing(Personality::getSurName).thenComparing(Personality::getName))
                    .limit(4)
                    .map(Personality::getSurName).toList();
            System.out.println(people);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public static void task3() {
        List<Integer> number = IntStream.range(3, 1000)
                .filter(n -> n % 3 == 0 && n % 5 == 0).boxed().toList();
        System.out.println(number);
    }
}
