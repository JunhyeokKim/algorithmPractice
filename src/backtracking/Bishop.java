package backtracking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-26.
 */
public class Bishop {

    private static int[][] mat;
    private static int sum=0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new FileInputStream("input7.txt"));

        int n=sc.nextInt();
        mat=new int[n][n];
        for(int i=0; i<sc.nextInt(); i++){
            for(int j=0; j<sc.nextInt(); j++)
                mat[i][j]=sc.nextInt();

        }





    }
}
