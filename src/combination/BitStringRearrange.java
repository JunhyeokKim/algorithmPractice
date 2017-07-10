package combination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-25.
 */
public class BitStringRearrange {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input5.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] bits = new char[n];
        char[] oneFirstBits = new char[n];
        char[] zeroFirstBits = new char[n];
        int[] continuousCode = new int[m];
        int zeroCount = 0;
        int oneCount = 0;
        int evenSum = 0, oddSum = 0;
        boolean zeroFirstEnable = false;
        boolean oneFirstEnable = false;
        int minCost=Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            bits[i] = sc.next().charAt(0);
            if (bits[i] == '0') {
                zeroCount++;
            } else if (bits[i] == '1') {
                oneCount++;
            }
        }

        for (int i = 0; i < m; i++) {
            continuousCode[i] = sc.nextInt();

            if (i % 2 == 0)
                evenSum += continuousCode[i];
            else
                oddSum += continuousCode[i];
        }
        if (oddSum == zeroCount && evenSum == oneCount) {
            zeroFirstEnable = true;
        }
        if (oddSum == oneCount && evenSum == zeroCount) {
            oneFirstEnable = true;
        }
        int idx=0;
        boolean flag = true;
        if (zeroFirstEnable) {
            for (int i : continuousCode
                    ) {
                if (flag) {
                    for (int j = 0; j < i; j++) {
                        zeroFirstBits[idx++] = '0';
                    }
                } else
                    for (int j = 0; j < i; j++) {
                        zeroFirstBits[idx++] = '1';
                    }
                flag=!flag;
            }
        }
        idx=0;
        flag=true;
        if (oneFirstEnable) {
            for (int i : continuousCode
                    ) {
                if (flag)
                    for (int j = 0; j < i; j++) {
                        oneFirstBits[idx++] = '1';
                    }
                else
                    for (int j = 0; j < i; j++) {
                        oneFirstBits[idx++] = '0';
                    }
                flag=!flag;
            }
        }

        if(zeroFirstEnable){
            for(int i=0; i<n; i++){
                if(bits[i]!=zeroFirstBits[i]){

                }
            }
        }



    }


}
