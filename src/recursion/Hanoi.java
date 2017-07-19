package recursion;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by junhyeok on 2017-07-14.
 * Problem No: 1914
 */
public class Hanoi {
    public static StringBuilder buf = new StringBuilder();


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
            // 옮길 판이 1개인 경우
            buf.append(home + " " + to + "\n");
            return 1;
        } else {
            // empty: home, to를 제외한 남는 공간
            int empty;
            if (home == 1 && to == 2 || home == 2 && to == 1)
                empty = 3;
            else if (home == 1 && to == 3 || home == 3 && to == 1)
                empty = 2;
            else
                empty = 1;
            long sum = 0;
            // 가장 밑의 원판을 제외한 위의 n-1개의 원판을 home에서 empty로 옮김
            sum += hanoi(n - 1, home, empty);
            // 가장 밑의 원판을 home에서 to로 옮김
            sum += hanoi(1, home, to);
            // empty의 원판들을 다시 to로 옮김. 이를 마치면 n개의 원판을 home에서 to로 옮긴 것이다
            sum += hanoi(n - 1, empty, to);
            return sum;
        }
    }
}
