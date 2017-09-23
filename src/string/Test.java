package string;

import java.io.*;
import java.util.Arrays;

/**
 * Created by junhyeok on 2017-08-19.
 */

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        StringBuilder bd = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (cnt[(int) str[i] - 97] == -1)
                cnt[(int) str[i] - 97] = i;
        }
        for (int i = 0; i < cnt.length; i++) {
            bd.append(cnt[i] + " ");
        }
        System.out.println(bd.toString());
    }

}


 
 
 