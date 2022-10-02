public class Work1 {
    public static void main(String[] args) {
        Work1 homework4 = new Work1();
        task1(1, 10);
        task2(1, 25);
        Work1.task3();
        System.out.println(homework4.task4());
        Work1.task5();
        Work1.task6();
    }

    public static void task1(int f1, int f2) {
        for (int i = 1; i <= f2; i++) {
            f1 = f1 * i;
            System.out.print(f1 + " , ");
        }
        System.out.println();
    }

    public static void task2(int p1, int p2) {
        int p = 1;
        do {
            p1 *= p;
            p++;
        }
        while (p <= p2);
        System.out.print(p1);
        System.out.println();
    }

    public static void task3() {
        long num = 7893832445L;
        long sum = 0;
        long n = num;
        do {
            sum += n % 10;
            n /= 10;
        } while (n != 0);
        System.out.println(sum);
    }

    public static int task4() {
        int f = 50;
        int i = 0;
        while (f >= 50 && f <= 70) {
            if (isPrime(f)) {
                i++;
                if (i == 2) {
                    break;
                }
            }
            f++;
        }
        return f;
    }

    public static boolean isPrime(int n) {
        for (int j = 2; j <= n / j; j++) {
            if ((n % j) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void task5() {
        for (int i = 1; i <= 100; i++) {
            if ((i % 7) == 0) {
                System.out.println("Hope");
            }
        }
    }

    public static void task6() {
        long a = 200231400003L;
        System.out.println(String.valueOf(a).replaceAll("(?=(\\d{3})+$)", " "));

    }

}


