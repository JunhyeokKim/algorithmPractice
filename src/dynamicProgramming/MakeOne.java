package dynamicProgramming;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by acorn on 2017-07-20.
 */
public class MakeOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int n=10;
        System.out.println(make(n));
    }

    private static int make(int n) {

        if (n == 1) {
            return 0;
        } else if (n > 1 && n < 4) {
            return 1;
        } else {
            int[] arr = new int[n + 1];
            arr[1] = 0;
            arr[2] = 1;
            arr[3] = 1;
            for (int i = 4; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                if (i % 3 == 0) {
                    if (arr[i / 3] < min)
                        min = arr[i / 3];
                }
                if (i % 2 == 0) {
                    if (arr[i / 2] < min)
                        min = arr[i / 2];
                }
                if (arr[i - 1] < min)
                    min = arr[i - 1];
                arr[i] = min + 1;
            }
            return arr[n];
        }

    }
}
