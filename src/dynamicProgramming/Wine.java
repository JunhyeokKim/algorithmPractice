package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-21.
 * Problem NO:2156
 * dp를 이용한 최대값을 구하는 문제. 연속적으로 3개 이상 선택하지 못함.
 * 최대값 cost[n]은 3가지 부분집합으로 이루어져있다. 문제를 더 작은 문제로 쪼개는 것을 연습해야 한다.
 * 1. n번째를 선택하고 n-1번쨰는 선택하지 않을 때 n-2까지의 최대값 cost[n-2]  ~XO
 * 2. n번째를 선택하지 않고 n-1번째까지의 최대값 cost[n-1]   ~X
 * 3. n번째를 선택하고 n-1,n-2번째를 선택하지 않았을 때 n-3까지의 최대값 cost[n-3]  ~XXO
 */
public class Wine {
    public static int[] cost;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("wine.txt")));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cost = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        if (n > 0) {
            cost[0] = arr[0];
        }
        if (n > 1) {
            cost[1] = arr[0] + arr[1];
        }
        if (n > 2) {
            cost[2] = Math.max(Math.max(arr[0] + arr[1], arr[0] + arr[2]), arr[1] + arr[2]);
        }
        System.out.println(cal(n));
    }

    public static int cal(int n) {
        for (int i = 3; i < n; i++) {
            cost[i] = Math.max(Math.max(arr[i] + cost[i - 2], arr[i] + arr[i - 1] + cost[i - 3]), cost[i - 1]);
        }
        return cost[n - 1];
    }

}
