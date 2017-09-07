package kakao.second;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by acorn on 2017-09-07.
 */
public class P03 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int[] ans = solution(v);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(int[][] v) {
        Set<Integer> xSet= new HashSet<>();
        Set<Integer> ySet= new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int x = v[i][0];
            int y = v[i][1];
            if(!xSet.contains(x)){
                xSet.add(x);
            }else{
                xSet.remove(x);
            }
            if(!ySet.contains(y)){
                ySet.add(y);
            } else{
                ySet.remove(y);
            }
        }
        int ansX= (int)xSet.toArray()[0];
        int ansY= (int)ySet.toArray()[0];
        int[] answer = {ansX,ansY};

        return answer;
    }
}
