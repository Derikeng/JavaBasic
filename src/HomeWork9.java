import java.util.*;


public class HomeWork9 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }
/*Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
 Удалить неудовлетворительные оценки из списка.
 */
    public static void task1() {
        ArrayList<Integer> grade = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            grade.add((int) (Math.random() * 10 + 1));
        }
        System.out.println(grade);
        for (int i = 0; i < grade.size(); i++) {
            if (grade.get(i) < 4) {
                grade.remove(i);
                i--;

            }
        }
        System.out.println(grade);
    }
/*Создать коллекцию, заполнить ее случайными целыми числами.
 Удалить повторяющиеся числа. Результат - коллекция без повторов.
 */
    public static void task2() {
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            number.add((int) (Math.random() * 10 + 1));

        }

        System.out.println(number);
        Set<Integer> set = new LinkedHashSet<>(number); // сохранение порядка поступления
        System.out.println(set);
        Set<Integer> set1 = new HashSet<>(number); // сортировка порядка поступления
        System.out.println(set1);
    }
/*Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
 Найти самую высокую оценку с использованием итератора.
 */
    public static void task3() {
        ArrayList<Integer> grade = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            grade.add((int) (Math.random() * 10 + 1));
        }
        System.out.println(grade);
        Iterator<Integer> iterator = grade.iterator();
        int max = 0;
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next());

        }
        System.out.println(max);
    }
/*Ввести текст с клавиатуры. Для текста создать Map, где ключом будет слово,
 а значение – количество повторений этого слова в тексте.
 */
    public static void task4() {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Введите предложения: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] words = s.split("[-,.:;\\s]+");
        for (String word : words)
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        System.out.println(map);
    }
}
