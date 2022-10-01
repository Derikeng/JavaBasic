import java.util.Arrays;

import static java.lang.System.out;

public class Work2 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }

    public static void task1() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
            out.print(arr[i] + " ");
        }
        out.print(" = [" + arr[9] + "]");
        out.println();
    }

    public static void task2() {
        int[] arr = {1, 4, 7, 20, 43, 56, 79, 80, 99, 22};
        out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i += 2) {
            out.print(arr[i] + "\t");

        }
    }

    public static void task3() {
        int[] arr = new int[10];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
            out.print(arr[i] + " ");
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        out.println("Max element = " + max);
    }

    public static void task4() {
        int[] arr = new int[10];
        int indexOfMax = 0;
        int indexOfMin = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
            out.print(arr[i] + " ");
            if (arr[i] >= arr[indexOfMax])
                indexOfMax = i;
            else if (arr[i] < arr[indexOfMin])
                indexOfMin = i;
        }
        for (int m = Math.min(indexOfMax, indexOfMin) + 1; m < Math.max(indexOfMax, indexOfMin); m++) {
            sum += arr[m];
        }
        out.println();
        out.println("Max = " + indexOfMax + " Min = " + indexOfMin);
        out.println();
        out.println("Sum = " + sum);
    }

    public static void task5() {
        int[] arr = new int[10];
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
            out.print(arr[i] + " ");
        }
        for (int i = arr.length; i > 0; i--) {
            reversed.append(arr[i - 1]).append(" ");
        }

        String[] reversedArray = reversed.toString().split(" ");
        out.println();
        System.out.println(Arrays.toString(reversedArray));
    }

    public static void task6() {
        int arr[][] = new int[5][5];
        int i, j;
        for (i = 0; i < arr.length / 2 + 1; i++) {
            for (j = 0; j < arr[i].length; j++) {
                if ((j < i) || (j >= (arr[i].length - i)))
                    arr[i][j] = 0;
                else
                    arr[i][j] = 1;
            }

        }
        for (i = arr.length - 1; i >= arr.length / 2; i--) {
            for (j = 0; j < arr[i].length; j++) {
                if ((j < (arr[i].length - 1 - i)) || (j > i))
                    arr[i][j] = 0;
                else
                    arr[i][j] = 1;
            }
        }
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                out.print(arr[i][j]);
            }
            out.println(" ");
        }
    }
}
