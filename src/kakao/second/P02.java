package kakao.second;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-09-07.
 */
public class P02 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {4,1,3};
        System.out.println(solution(arr));

    }

    public static boolean solution(int[] arr) {
        boolean answer = true;
        boolean[] check = new boolean[arr.length];  // 1~n까지 중복 여부
        for (int i = 0; i < arr.length; i++) {
            // 중복, 범위 check
            if (arr[i] < 1 || arr[i] > arr.length) {
                answer = false;
                break;
            } else if(check[arr[i]-1]){
                answer=false;
                break;
            }
            check[arr[i]-1]=true;
        }
        return answer;
    }
}
