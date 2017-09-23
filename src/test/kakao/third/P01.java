package test.kakao.third;

import java.io.*;

/**
 * Created by junhyeok on 2017-09-16.
 */

public class P01 {
    public static void main(String[] args) throws IOException {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] ans = solution(n, arr1, arr2);
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = arr1[i] | arr2[i];
        }
        for (int i = 0; i < n; i++) {
            StringBuilder bd = new StringBuilder();
            for (int j = 0; j < n; j++) {
                bd.append((((map[i]&(1<<(n-j-1)))>>(n-j-1)==1)?'#':' '));
            }
            ans[i] = bd.toString();
        }
        return ans;
    }

}


 
 
 