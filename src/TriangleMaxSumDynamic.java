import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-21.
 */
public class TriangleMaxSumDynamic {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input3.txt"));
        //Scanner sc= new Scanner(System.in);
        for (int t = 1; t <= 1; t++) {
            //int h = t;
            int h = sc.nextInt();

            int[] cost = new int[h];
            int[][] arr = new int[h][];
            int[] maxIdx = new int[h];
            for (int i = 0; i < h; i++) {
                arr[i] = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    //arr[i][j] = (int)(Math.random()*100);
                    arr[i][j] = sc.nextInt();

                }
                maxIdx[i] = -1;
            }
            System.out.println(getCost(maxIdx, arr, cost, h - 1));
        }
    }

    static int getCost(int[] maxIdx, int[][] arr, int[] cost, int h) {
        for (int n = 0; n <= h; n++) {
            if (n == 0) {
                cost[0] = arr[0][0];
                maxIdx[0] = 0;
            } else if (n == 1) {
                cost[1] = cost[0] + Math.max(arr[1][0], arr[1][1]);
                maxIdx[1] = (arr[1][0] > arr[1][1]) ? 0 : 1;
            } else {

                int left = cost[n - 2] + arr[n - 1][maxIdx[n - 2]] + Math.max(arr[n][maxIdx[n - 2]], arr[n][maxIdx[n - 2] + 1]);
                int right = cost[n - 2] + arr[n - 1][maxIdx[n - 2] + 1] + Math.max(arr[n][maxIdx[n - 2] + 1], arr[n][maxIdx[n - 2] + 2]);
                if (left > right) {
                    cost[n] = left;
                    maxIdx[n - 1] = maxIdx[n - 2];
                    cost[n - 1] = cost[n - 2] + arr[n - 1][maxIdx[n - 1]];
                    if (arr[n][maxIdx[n - 2]] > arr[n][maxIdx[n - 2] + 1]) {
                        maxIdx[n] = maxIdx[n - 2];
                    } else {
                        maxIdx[n] = maxIdx[n - 2] + 1;

                    }

                } else {
                    cost[n] = right;
                    maxIdx[n - 1] = maxIdx[n - 2] + 1;
                    cost[n - 1] = cost[n - 2] + arr[n - 1][maxIdx[n - 1]];
                    if (arr[n][maxIdx[n - 2] + 1] > arr[n][maxIdx[n - 2] + 2]) {
                        maxIdx[n] = maxIdx[n - 2] + 1;
                    } else {
                        maxIdx[n] = maxIdx[n - 2] + 2;
                    }

                }
            }
        }
        return cost[h];
    }


}
