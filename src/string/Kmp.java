package string;

import java.io.*;
import java.util.Arrays;

/**
 * Created by junhyeok on 2017-08-14.
 */

public class Kmp {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/kmp.txt")));
        StringBuilder bd = new StringBuilder();
        char[] T = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();
        pi = new int[p.length];
        int cnt = 0;
        findK(p);
        int j = 0;
        for (int i = 0; i < T.length; i++) {
            while (j > 0 && T[i] != p[j]) {
                j = pi[j - 1];
            }
            if (T[i] == p[j]) {
                if (j == p.length - 1) {
                    cnt++;
                    bd.append((i - j + 1) + " ");
                } else {
                    ++j;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(bd.toString());
    }


    static void findK(char[] p) {
        int j = 0;
        for (int i = 1; i < p.length; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
    }

}


 
 
 