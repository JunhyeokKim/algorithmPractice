package string;

import java.io.*;
import java.util.Arrays;

/**
 * Created by junhyeok on 2017-08-14.
 * Problem No:1786
 * 문자열 검색 알고리즘인 KMP의 구현에 관한 알고리즘이다
 * 1. 문자열 S와 검색 패턴 P를 입력으로 받음 (예제: S: ABCDABCDABDE,   P:ABCDABD )
 * i= S의 인덱스, j= P의 인덱스라고 정한다( 초기값은 0)
 * 2. S[i]!=P[j]인 구간이 존재한다면
 * 2-1. i-1까지의 검색결과는 중복되므로 생략이 가능하고
 * 2-2. 만약 패턴 P가 ABCDABD와 같은 형태이고 i=7, j=7번째에서 문자가 불일치할 경우 i=7까지의 검사 중 P의 0~1번째 인덱스인
 * AB가 S의 5~6번째와 매칭된다는 사실을 알고 있기 때문에 생략할 수 있다.
 * 2-3. 따라서 이러한 중복값에 대한 전처리값인 pi를 미리 구하고, 불일치가 일어날 경우 j=pi[j-1]의 형태로 갱신한다.
 * 자세한건 알고리즘 다시봐라..
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
                    j=pi[j];
                } else {
                    ++j;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(bd.toString());
    }


    static void findK(char[] p) {
         /*fail function(pi)를 초기화하기 위한 함수
         * kmp 알고리즘과 유사한 방식으로 pi를 초기화한다.
         *
         * */


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


 
 
 