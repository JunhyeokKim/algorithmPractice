package recursion;

import java.util.Scanner;

/**
 * Created by acorn on 2017-07-10.
 */
public class Z {
    public static int tot = 0;
    public static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        search(n, r, c);

    }

    public static void search(int n, int r, int c) {
        // size가 0인 경우 증가 시키고 종료
        if (n == 0) {
            tot++;
        }
        // 그렇지 않은 경우 왼쪽 상단, 오른쪽 상단, 왼쪽 하단, 오른쪽 하단 순으로 재귀 반복
        else {
            int k;
            // 현재 r,c의 위치가 어느 사분면인지 확인
            if (r <= n / 2 && c <= n / 2) { // 1사분면
                k = 1;
            } else if (r <= n / 2 && c > n / 2) { // 2사분면
                k = 2;
            } else if (r > n / 2 && c <= n / 2) { //3사분면
                k = 3;
            } else { // 4사분면
                k = 4;
            }
            for(int i=0; i<k; i++){

            }

            n /= 2;
        }
    }
}
