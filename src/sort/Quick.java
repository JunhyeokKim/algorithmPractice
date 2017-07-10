package sort;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 1, 4, 11, 5};
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        quickSort(arr, 0, arr.length - 1);
        System.out.println();
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }

    public static void quickSort(int[] arr, int p, int r) {
        // 정렬한 데이터가 존재하는 경우
        if (p < r) {
            // pivot index를 구한다
            int q = partition(arr, p, r);
            // 왼쪽 배열을 정렬
            quickSort(arr, p, q - 1);
            // 오른쪽 배열을 정렬
            quickSort(arr, q + 1, r);
        }
    }

    public static int partition(int[] arr, int p, int r) {
        // pivot은 배열의 마지막으로 지정
        int pivot = arr[r];
        // 0~i까지 원소는 pivot 이하의 값을 가진 값만 모임
        int i = p - 1;
        // i+1 은 pivot의 위치, 그 이후의 원소는 pivot 보다 큰 데이터가 위치함
        int j = p;
        // 모든 원소 (p 부터 pivot 이전의 원소)와 pivot을 비교
        while (j < r) {
            // pivot 보다 큰 값을 갖는 경우
            if (arr[j] > pivot) {
                j++;
            }
            // pivot 이하의 값을 갖는 경우, i의 인덱스를 증가시키고 i와 j의 원소를 교체한 후 j의 인덱스를 증가시킨다.
            // 이는 왼쪽 배열의 범위를 1 증가시키고 오른쪽 배열의 시작점 또한 1 증가시키는 것과 같다.
            else {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        // 이제 pivot을 올바른 위치에 위치시킨다.  pivot을 기준으로 왼쪽 배열은 0~i까지 이므로 그 다음인 i+1이 pivot의 올바른 위치다.
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }
}
