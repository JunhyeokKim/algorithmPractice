package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-02.
 * Problem No: 1912
 * DP를 이용한 연속합 계산이다.
 * DP에 대한 고정관념과 꽉막힌 사고회로 덕분에 O(n)의 문제를 거의 O(n^3)의 행렬곱 방식으로 풀려고 하였다.
 * 풀 수 있었으면 다행이지만, 중간에 - 부분이 포함된 sub-problem에 대한 정의가 모호하여 힘들다고 생각하였고 결국 힌트를 봤더니
 * for문 한번에 그냥 끝난다.. 심지어 생각보다 간단했다.. 배열을 반복문을 돌면서 현재 인덱스까지의 합이 현재 인덱스의 값보다 크다면 그 합을 해당 인덱스에서의
 * 연속합으로 정하고 그렇지 않다면 음수를 만난 경우이기 때문에 연속되는 부분이 중단되므로 현재 인덱스에서의 연속합을 현재 인덱스의 값으로 초기화한다.
 * 또 반복하면서 최대 연속합을 max값과 비교해나가면서 갱신한다. 이리도 쉬운것을 0~7까지의 연속합을 0~1, 2~7 중 최댓값 방식으로 풀려고 하니..
 *
 *
 */
public class ContinuousSum {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("continuousSum.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] + arr[i - 1] > arr[i]) {
                arr[i] = arr[i] + arr[i - 1];
            } else {
                arr[i] = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
        /*for (int r = 0; r < n; r++) {
            for (int i = 0; i < n - r; i++) {
                int j = r + i;
                if (r == 0) {
                    d[i][j] = arr[i];
                } else {
                    int max = Integer.MIN_VALUE;
                    int minus = i;
                    for (int k = i; k < j; k++) {
                        int temp;
                        if (d[i][k] >= 0 && d[k + 1][j] >= 0 && arr[k] >= 0 && arr[k + 1] >= 0) {

                            temp = d[i][k] + d[k + 1][j];
                        } else {
                            temp = Math.max(d[i][k], d[k + 1][j]);
                        }
                        if (max < temp) {
                            max = temp;
                        }
                        System.out.println(String.format("r: %d, i: %d, j: %d, k: %d", r, i, j, k));
                    }
                    d[i][j] = max;
                }
            }
        }*/


    }
}
