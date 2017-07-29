package graph.shortestPath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-07-29.
 * Problem No:1753
 * Dijkstra 알고리즘을 통해 single-source 최단경로 문제를 해결하는 문제이다.
 * 1. 모든 정점까지의 최단거리 d를 무한대로 초기화
 * 2. 시작점 s의 최단거리 d[s]=0으로 초기화
 * 3. 시작정점 s를 우선순위큐에 삽입. 시작정점에 인접한 정점들을 큐에 삽입.
 * 4. 큐에 속한 정점 중 최단거리를 갖는 정점을 가져옴. 이것이 확정될 최단거리이다.
 *
 */
public class ShortestPath {
    public static ArrayList<Vertex>[] adjVertexs;
    public static int[] d;
    public final static int MAX = 3000000;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("shortestPath.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder bd = new StringBuilder();
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());
        d = new int[v + 1];
        // 모든 정점까지의 최단거리 d를 무한대로 초기화한다.
        Arrays.fill(d, MAX);
        // 시작점의 최단거리는 0
        d[s] = 0;
        // i번째 정점과 인접한 정점들과 가중치들을 저장하는 arrayList이다.
        adjVertexs = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++)
            adjVertexs[i] = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            adjVertexs[Integer.parseInt(st.nextToken())].add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        // 집합 S(최단 경로의 후보)을 나타내기 위한 Priority Queue이다. S에 있는 정점들 중 시작점 s로부터 거리가 가장 가까운 정점을 뽑아온다.
        // queue에서 제거된 정점들에 대해서는 이미 최단거리가 구해진 시점이다.
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        // 시작 정점을 추가한다.
        queue.add(new Vertex(s, d[s]));
        while (!queue.isEmpty()) {
            // 집합 S중 가장 짧은 거리를 갖는 정점.
            Vertex selectedV = queue.remove();
            ArrayList<Vertex> adj = adjVertexs[selectedV.v];
            // 선택된 정점의 인접한 정점들에 대해 relax 연산을 한다
            if (adj != null) {
                for (Vertex adjVertex : adj) {
                    if (d[adjVertex.v] > d[selectedV.v] + adjVertex.w) {
                        d[adjVertex.v] = d[selectedV.v] + adjVertex.w;
                        // 새로운 최단거리를 갖는 경로를 찾았다. 이 정점을 큐에 넣어서 후보로 만든다.
                        queue.add(new Vertex(adjVertex.v, d[adjVertex.v]));
                    }
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            bd.append((d[i] == MAX ? "INF" : d[i]) + "\n");
        }
        System.out.println(bd.toString());
    }

    private static class Vertex implements Comparable<Vertex> {
        int v;
        int w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Vertex o) {
            if (this.w < o.w) {
                return -1;
            } else if (this.w == o.w) {
                return 0;
            } else {
                return 1;
            }
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
