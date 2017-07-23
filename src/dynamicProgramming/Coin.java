package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-21.
 * Problem No: 2293
 * n개의 서로 다른 동전과 k원이 주어졌을 때 k원을 만들 수 있는 모든 경우의 수를 구하는 문제이다. 각 동전은 중복으로 사용이 가능하다.
 * k원을 만드는 모든 경우의 수는
 * k원을 1~ n-1번째 동전을 사용하여 만드는 경우의 수
 * + 1~n까지의 동전을 사용하여 k-coin(n)원을 만드는 경우의 수로 구할 수 있다.
 * 이는 n번째 동전을 사용하지 않고 만드는 경우의 수와
 * n번째 동전을 1번 이상 사용하여 만드는 경우의 수의 합과 같다
 */
public class Coin {
    public static int[][] cost;
    public static int[] coin;


    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("coin.txt")));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        cost = new int[n][k + 1];
        coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = Integer.parseInt(br.readLine());
        System.out.println(count(n, k));
    }

    private static int count(int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    cost[i][j] = 1;
                else {
                    if (i > 0)
                        cost[i][j] += cost[i - 1][j];
                    if (j >= coin[i])
                        cost[i][j] += cost[i][j - coin[i]];
                }
            }
        }
        return cost[n - 1][k];
    }


}
