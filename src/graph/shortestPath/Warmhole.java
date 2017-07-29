package graph.shortestPath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-07-29.
 * Problem NO: 1865
 * 벨만포드 알고리즘을 사용하여 음수 사이클의 존재 유무를 판단하는 문제이다.
 * 보통 벨만포드 알고리즘에서는 n-1번 각 엣지들에 대해 relax하면 시작정점으로부터 모든 정점에 대한 최단거리가 구해지지만,
 * 음수 사이클이 존재하는 경우 n번째, 즉 모두 구해진 상태에서도 relax를 수행하면 최단거리가 감소한다.
 * 또한 음수 사이클을 검사하는데에는 시작 정점의 위치는 무관하다.
 */
public class WarmHole {
    public final static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("warmHole.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        StringBuilder bd = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        ArrayList<Vertex>[] adjVertexs;
        int[] d;
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            d = new int[n + 1];
            Arrays.fill(d, MAX);
            d[1] = 0;
            adjVertexs = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adjVertexs[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adjVertexs[u].add(new Vertex(v, w));
                adjVertexs[v].add(new Vertex(u, w));
            }
            for (int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                adjVertexs[Integer.parseInt(st.nextToken())].add(new Vertex(Integer.parseInt(st.nextToken()), -1 * Integer.parseInt(st.nextToken())));
            }
            if (checkCycle(n, adjVertexs, d)) {
                bd.append("YES\n");
            } else {
                bd.append("NO\n");
            }
        }
        System.out.println(bd.toString());
    }

    private static boolean checkCycle(int n, ArrayList<Vertex>[] adjVertexs, int[] d) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Vertex adjVertex : adjVertexs[j]
                        ) {
                    if (d[adjVertex.v] > d[j] + adjVertex.w) {
                        d[adjVertex.v] = d[j] + adjVertex.w;
                        if (i == n)
                            return true;
                    }
                }

            }
        }
        return false;
    }


    private static class Vertex {
        int v;
        int w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
}
