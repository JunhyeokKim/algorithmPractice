package recursion;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by junhyeok on 2017-07-14.
 * Problem No: 1914
 */
public class Hanoi {
    public static StringBuffer buf = new StringBuffer();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 20) {
            System.out.println(hanoiLarge(n));
        } else {
            System.out.println(hanoi(n, 1, 3));
            System.out.println(buf.toString().trim());
        }
    }

    public static BigInteger hanoiLarge(int n) {
        BigInteger tot = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            tot = tot.multiply(BigInteger.valueOf(2));
        }
        tot = tot.subtract(BigInteger.ONE);
        return tot;
    }

    public static long hanoi(int n, int home, int to) {
        if (n == 1) {
            buf.append(home + " " + to + "\n");
            return 1;
        } else {
            int empty;
            if (home == 1 && to == 2 || home == 2 && to == 1)
                empty = 3;
            else if (home == 1 && to == 3 || home == 3 && to == 1)
                empty = 2;
            else
                empty = 1;
            long sum = 0;
            sum += hanoi(n - 1, home, empty);
            sum += hanoi(1, home, to);
            sum += hanoi(n - 1, empty, to);
            return sum;
        }
    }
}
