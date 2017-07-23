package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-21.
 */
public class Coin {
    public static int[] cost;
    public static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("coin.txt")));
        //BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream("coin.txt")));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        cost = new int[k + 1];
        coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = Integer.parseInt(br.readLine());
        System.out.println(gogo(k));
    }

    public static int gogo(int k) {
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < coin.length; j++) {
                if (i == coin[j]) {
                    cost[i]++;
                }
                if (i > coin[j])
                    cost[i] += cost[i - coin[j]];
            }
        }
        return cost[k];
    }
}
