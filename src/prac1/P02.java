package prac1;

import java.io.*;
import java.util.*;

/**
 * Created by junhyeok on 2017-09-17.
 */

public class P02 {
    final static int TOT_PAIR = 153;
    final static int[] DIF = {4, 5, 4, 5, 4, 5, 4, 5, 4, 5};


    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        /*//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/file.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();*/
        /*int c1= Integer.parseInt(st.nextToken());
        int c2= Integer.parseInt(st.nextToken());*/
        int c1 = 1;
        int c2 = 2;
        System.out.println(Math.round(solution(c1, c2) * 1000d) / 1000d);
    }

    private static float solution(int c1, int c2) {
        float ans = 0;
        if (c1 == c2) {
            // same card
            ans = 1 - ((10 - c1) / (float) TOT_PAIR);
        } else {
            int last = (c1 + c2) % 10;
            int dif = 0;
            for (int i = 0; i < last - 1; i++) {
                dif += DIF[i];
            }
            ans = (2*dif / (float) TOT_PAIR);
        }
        return ans;
    }

}


 
 
 