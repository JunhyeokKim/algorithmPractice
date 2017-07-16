package dynamicProgramming;

/**
 * Created by junhyeok on 2017-07-14.
 */
public class Fibonacci {
    public static int[] arr;

    public static void main(String[] args) {
        int n = 46;
        arr = new int[n];
        double s=System.nanoTime();
        System.out.println(fibonacciTopDown(n - 1));
        double e= System.nanoTime();
        System.out.println("수행 시간: "+(e-s)/1000000000);
        s=System.nanoTime();
        System.out.println(fibonacciBottomUp(n - 1));
        e=System.nanoTime();
        System.out.println("수행 시간: "+(e-s)/1000000000);
        s=System.nanoTime();
        System.out.println(fibonacci(n - 1));
        e=System.nanoTime();
        System.out.println("수행 시간: "+(e-s)/1000000000);
    }

    public static int fibonacci(int n) {
        if (n < 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciTopDown(int n) {
        if (n < 2) {
            arr[n] = 1;
            return 1;
        } else if (arr[n] != 0) {
            return arr[n];
        } else {
            arr[n] = fibonacciTopDown(n - 1) + fibonacciTopDown(n - 2);
            return arr[n];
        }

    }

    public static int fibonacciBottomUp(int n) {
        if(n<2)
            return 1;
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
