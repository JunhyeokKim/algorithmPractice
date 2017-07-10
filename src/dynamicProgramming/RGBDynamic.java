package dynamicProgramming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-20.
 */
public class RGBDynamic {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input2.txt"));
        //Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] rgb;
        int[] cost;
        int[] table;        //r:0, g:1, b:2
        int result;
        rgb = new int[n][3];
        table = new int[n];
        cost = new int[n];

        for (int i = 0; i < n; i++) {
            rgb[i][0] = sc.nextInt();
            rgb[i][1] = sc.nextInt();
            rgb[i][2] = sc.nextInt();
            table[i] = -1;

        }


        System.out.println(cost[n - 1]);
    }


    static int findMin(int[] rgb) {
        int minIdx = 0;
        if (rgb[0] > rgb[1]) {
            minIdx = 1;
            if (rgb[1] > rgb[2]) {
                minIdx = 2;
            }
        } else if (rgb[0] > rgb[2]) {
            minIdx = 2;
            if (rgb[2] > rgb[1]) {
                minIdx = 1;
            }
        }
        return minIdx;
    }


    static int calCost(int[][] rgb, int[]cost, int[]table, int n){
        if(n==0){
            return 0;
        }
        else if(n==1&& table[0]==-1){
            table[0]=findMin(rgb[0]);
            cost[0]=rgb[0][table[0]];
            return cost[0];
        }
        else if(n==2 && table[1]==-1){
            table[1]=findMin(rgb[1]);
            if(table[0]==table[1]){
                int []temp0= rgb[0];
                int []temp1=rgb[1];
                temp0[table[0]]=Integer.MAX_VALUE;
                temp1[table[1]]=Integer.MAX_VALUE;
                int temp0Idx=findMin(temp0);
                int temp1Idx=findMin(temp1);
                if(rgb[0][table[0]]+rgb[1][temp1Idx]>rgb[0][temp0Idx]+rgb[1][table[1]]){
                    table[0]=temp0Idx;
                }
                else{
                    table[1]=temp1Idx;
                }
                cost[1]=rgb[0][table[0]]+rgb[1][table[1]];
                return cost[1];
            }
        }
        else{

        }
        return 0;
    }

}

