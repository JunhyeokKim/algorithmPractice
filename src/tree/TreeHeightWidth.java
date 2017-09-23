package tree;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-14.
 * Problem No:  2250
 * 트리의 특성을 잘 이해하는지 묻는 문제. 그 중 트리의 탐색 방법에 대한 이해를 묻고 있었음.
 * 중위순회를 하게 될 때 방문 순서가 곧 x축의 위치가 된다는 점을 활용하면 된다.
 * 그 후 각 레벨별로 최대x와 최소 x값을 구하고 그것의 최대 차를 구하면 된다.
 */

public class TreeHeightWidth {
    static int[][] trees;
    static int[] xPos;
    static int pos;
    static int level;
    static int[] mostLeft;
    static int[] mostRight;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/treeHeightWidth.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        trees = new int[n + 1][2];
        xPos = new int[n + 1];
        mostLeft = new int[n + 1];
        Arrays.fill(mostLeft, 1000000);
        mostRight = new int[n + 1];
        boolean[] isNotRoot = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int ld = Integer.parseInt(st.nextToken());
            int rd = Integer.parseInt(st.nextToken());
            if (ld != -1) {
                trees[parent][0] = ld;
                isNotRoot[ld] = true;
            }
            if (rd != -1) {
                trees[parent][1] = rd;
                isNotRoot[rd] = true;
            }
        }
        int root = 0;
        for (int i = 1; i < isNotRoot.length; i++) {
            if (!isNotRoot[i]) {
                root = i;
                break;
            }

        }
        inorder(root, 1);
        int maxLevel = 1;
        int maxWidth = 1;
        for (int i = 1; i <= level; i++) {
            if (maxWidth < mostRight[i] - mostLeft[i] + 1 && mostLeft[i] != mostRight[i]) {
                maxWidth = mostRight[i] - mostLeft[i] + 1;
                maxLevel = i;
            }
        }
        System.out.println(maxLevel + " " + maxWidth);
    }

    static void inorder(int node, int lv) {
        int left = trees[node][0];
        int right = trees[node][1];
        if (level < lv) {
            level = lv;
        }
        if (left != 0) {
            inorder(left, lv + 1);
        }
        xPos[node] = ++pos;
        if (xPos[node] < mostLeft[lv]) {
            mostLeft[lv] = xPos[node];
        }
        if (xPos[node] > mostRight[lv]) {
            mostRight[lv] = xPos[node];
        }
        if (right != 0) {
            inorder(right, lv + 1);
        }

    }
}


 
 
 