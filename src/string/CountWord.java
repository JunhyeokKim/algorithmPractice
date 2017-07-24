package string;

import java.io.*;

/**
 * Created by acorn on 2017-07-24.
 */
public class CountWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("countWord.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int[] count = new int['z' - 'a'+1];
        for (int i = 0; i < str.length; i++) {
            if (str[i] < 91) { // upper case
                count[str[i] - 65]++;
            } else {  //lower case
                count[str[i] - 97]++;
            }
        }
        int max1 = 0;
        int maxIdx1 = 0;
        for (int i = 0; i < count.length; i++) {
            if (max1 < count[i]) {
                max1 = count[i];
                maxIdx1 = i;
            }
        }
        int tempMax1=count[maxIdx1];
        count[maxIdx1] = 0;
        int max2 = 0;
        int maxIdx2 = 0;
        for (int i = 0; i < count.length; i++) {
            if (max2 < count[i]) {
                max2 = count[i];
                maxIdx2 = i;
            }
        }
        if(tempMax1==count[maxIdx2]){
            System.out.println("?");
        }else{
            System.out.println((char)(maxIdx1+65));
        }

    }

}
