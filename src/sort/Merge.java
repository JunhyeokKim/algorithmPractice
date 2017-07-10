package sort;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class Merge {

    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 1, 4, 11, 5};
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        mergeSort(arr, 0, arr.length - 1);
        System.out.println();
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }

    public static void mergeSort(int[] arr, int p, int r) {
        // 시작점과 끝점( 정렬할 배열의 원소가 2개 이상인 경우)9
        if (p < r) {
            // 중간점을 q로 지정
            int q = (p + r) / 2;
            // 중간점을 기준으로 왼쪽, 오른쪽 부분 배열을 각각 정렬한다
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            // 정렬된 왼쪽, 오른쪽 부분 배열을 merge한다
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        // 임시로 복사될 정렬된 배열
        int[] data = new int[arr.length];
        // 복사된 배열의 index
        int k = p;
        // 왼쪽 부분배열의 시작점
        int i = p;
        // 오른쪽 부분배열의 시작점
        int j = q + 1;
        // 두 배열 중 하나라도 각 배열의 끝에 도달하면 반복문을 중단한다.
        while (i <= q && j <= r) {
            // 두 부분배열의 참조 원소를 비교하여 작은 것을
            if (arr[i] <= arr[j]) {
                data[k++] = arr[i++];
            } else {
                data[k++] = arr[j++];
            }
        }
        //
        while (i <= q) {
            data[k++] = arr[i++];
        }
        while (j <= r) {
            data[k++] = arr[j++];
        }
        for (i = p; i <= r; i++) {
            arr[i] = data[i];
        }
    }
}
