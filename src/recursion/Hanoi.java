package recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by acorn on 2017-07-12.
 */
public class Hanoi {
    static int size[];
    static int head[];
    static int tot = 0;
    static int visited = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        size = new int[4];
        head = new int[4];
        head[1] = n;
        size[1] = n;
        moveTo(3, 1, 3);  // 3개의 원판을 (1~3 번호의 원판) 2번 판에 옮김
        System.out.println(tot);
    }

    public static void moveTo(int n, int prev, int to) {
        if (size[to] == n || head[to] > head[prev] || visited == to) {
            //
        } else if(n==1){
            System.out.println(prev + " " + to);
        }
        else {
            int empty = 1;
            if (prev == 1 && to == 3 || prev == 3 && to == 1) {
                empty = 2;
            } else if (prev == 3 && to == 2 || prev == 2 && to == 3) {
                empty = 1;
            } else if (prev == 1 && to == 2 || prev == 2 && to == 1) {
                empty = 3;
            }
            int tempHead = head[empty];
            head[empty] = n;
            size[empty]++;
            head[prev] = n - 1;
            size[prev]--;
            tot++;
            visited = prev;
            moveTo(n - 1, prev, to);
            head[empty] = tempHead;
            head[to] = n;
            head[prev] = n - 1;
            tot++;
            visited = prev;
            moveTo(n - 1, prev, to);
        }

    }


}
