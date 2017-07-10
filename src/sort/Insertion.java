package sort;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class Insertion {
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 1, 4, 11, 5};
        sort(arr);
    }

    static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 비교를 위한 key값(i)
            int compare = arr[i];
            // 0 ~ i-1까지의 배열은 이미 정렬되었음. i-1번째(정렬되지 않은 배열의 마지막 원소)부터 삽입 장소를 탐색한다.
            for (int j = i - 1; j >= 0; j--) {
                // compare값이 더 작은 경우
                if (arr[j] > compare) {
                    // 현재 j 인덱스의 원소를 한칸 뒤로 복사한다
                    arr[j + 1] = arr[j];
                    // 만약 현재 원소가 배열의 처음인 경우(삽입될 값이 가장 작은 경우)
                    if (j == 0) {
                        arr[j] = compare;
                        break;
                    }
                    // 삽입될 공간을 찾은 경우
                } else {
                    arr[j + 1] = compare;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
