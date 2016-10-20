import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-20.
 */
public class FibonacciDynamic {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int T;
        int n;
        int zeroCnt, oneCnt;
        T = sc.nextInt();
        int[][] table = new int[2][41];
        for (int t = 0; t < T; t++) {
            n = sc.nextInt();
            if (t == 0) {
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < n; j++)
                        table[i][j] = 0;
                table[0][0] = 1;
                table[1][1] = 1;
            }

            zeroCnt = fibonacciCnt(n, table, 0);
            oneCnt = fibonacciCnt(n, table, 1);
            System.out.println(String.format("%d %d", zeroCnt, oneCnt));
        }

    }

    static int fibonacciCnt(int n, int[][] arr, int target) {
      if(n>1) {
          if (arr[target][n - 1] == 0 && n > 1) {
              arr[target][n - 1] = fibonacciCnt(n - 1, arr, target);
          }
          if (arr[target][n - 2] == 0 && n > 1) {
              arr[target][n - 2] = fibonacciCnt(n - 2, arr, target);
          }
          arr[target][n] = arr[target][n - 1] + arr[target][n - 2];
          return arr[target][n];
      }
        else
          return arr[target][n];

    }
}
