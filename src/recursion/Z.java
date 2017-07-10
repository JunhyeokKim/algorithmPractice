package recursion;

import java.util.Scanner;

/**
 * Created by acorn on 2017-07-10.
 */
public class Z {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 2;
        int r = 1;
        int c = 2;
        /*int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();*/

        System.out.println(search(n, r, c) - 1);

    }

    public static int search(int n, int r, int c) {
        // size가 0인 경우 증가 시키고 종료
        if (n == 0) {
            return 1;
        }
        // 그렇지 않은 경우 왼쪽 상단, 오른쪽 상단, 왼쪽 하단, 오른쪽 하단 순으로 재귀 반복
        else {
            int k;
            int center = (int) Math.pow(2, n) / 2;
            // 현재 r,c의 위치가 어느 사분면인지 확인


            if (r < center && c < center) { // 1사분면
                k = 0;
            } else if (r < center && c >= center) { // 2사분면
                k = 1;
            } else if (r >= center && c < center) { //3사분면
                k = 2;
            } else { // 4사분면
                k = 3;
            }
            n--;
            int sum = search(n, center - 1, center - 1) * k;
            if (k == 1) {
                c = c - center;
            } else if (k == 2) {
                r = r - center;
            } else if (k == 3) {
                r = r - center;
                c = c - center;
            }
            return search(n, r, c) + sum;
        }
    }
}
