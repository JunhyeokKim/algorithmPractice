import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-20.
 */
public class FibonacciDynamic {
    public static void main(String[] args) {
        Scanner sc= new Scanner("input.txt");
        int T;
        int n;
        int zeroCnt, oneCnt;
        T=sc.nextInt();

        for(int t=0; t<T; t++){
            zeroCnt=0;
            oneCnt=0;
            n=sc.nextInt();


            System.out.println(String.format("%d %d",zeroCnt,oneCnt));
        }

    }
    static int fibonacci(int n){

        return 0;
    }
}
