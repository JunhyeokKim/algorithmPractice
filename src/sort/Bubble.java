package sort;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 1, 4, 11, 5};
        sort(arr);
    }

    static void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                // swap if arr[i]> arr[i+1]
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
