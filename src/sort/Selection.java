package sort;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class Selection {
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 1, 4, 11, 5};
        sort(arr);
    }

    static void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
