package test.nhn;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-09-22.
 */

public class T2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/nhn_t1.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd= new StringBuilder();
        int n= Integer.parseInt(st.nextToken());
        int[][] arr= new int[n][n];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        int[][] result= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j]=arr[j][i];
                bd.append(result[i][j]+" ");
            }
            bd= new StringBuilder(bd.toString().trim());
            bd.append("\n");
        }
        System.out.println(bd.toString());

    }

}


 
 
 