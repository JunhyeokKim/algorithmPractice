package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by junhyeok on 2017-08-05.
 */
public class P05 {
    public static void main(String[] args) {
        int[][] data = {{0, 0}, {1, 1}, {0, 2}, {2, 0}};
        System.out.println(solution(4, data));
    }

    public static int solution(int n, int[][] data) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        ArrayList<Pos> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pos p1 = new Pos(data[i][0], data[i][1]);
            points.add(p1);
        }

        Collections.sort(points);
        int maxX = 0;
        int maxY = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            Pos prev = points.get(i);
            for (int j = 0; j < points.size(); j++) {
                Pos to = points.get(j);
                if (i != j && !visited[i][j] && checkArea(prev, to, minX, minY, maxX, maxY)) {
                    if (checkAxis(prev, to)) {
                        if (prev.x > to.x) {
                            if (maxX < prev.x) {
                                maxX = prev.x;
                            }
                            if (to.x < minX) {
                                minX = to.x;
                            }
                        } else {
                            if (maxX < to.x) {
                                maxX = to.x;
                            }
                            if (prev.x < minX) {
                                minX = prev.x;
                            }
                        }
                        if (prev.y > to.y) {
                            if (maxY < prev.y) {
                                maxY = prev.y;
                            }
                            if (to.y < minY) {
                                minY = to.y;
                            }
                        } else {
                            if (maxY < to.y) {
                                maxY = to.y;
                            }
                            if (prev.y < minY) {
                                minY = prev.y;
                            }
                        }
                        answer++;
                        visited[i][j] = true;
                        visited[j][i] = true;
                        break;
                    }
                }
            }
        }
        /*for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Pos p1 = new Pos(data[i][0], data[i][1]);
                Pos p2 = new Pos(data[j][0], data[j][1]);
                Edge edge = new Edge(p1, p2);
                if (checkAxis(p1, p2))
                    if (!edges.contains(edge))
                        edges.add(edge);
            }
        }
        ArrayList<Edge> lowerEdges = new ArrayList<>();
        while (!edges.isEmpty()) {
            Edge edge = edges.remove();
            if (edge.len == 1) {
                answer++;
            } else {
                for(Edge lowerEdge: lowerEdges){
                    if()
                }
            }
            lowerEdges.add(edge);
        }*/

        return answer;
    }

    private static boolean checkArea(Pos prev, Pos to, int minX, int minY, int maxX, int maxY) {
        if (minX >= prev.x && minX >= to.x) {
            return true;
        }
        if (minY >= prev.y && minY >= to.y) {
            return true;
        }
        if (maxX <= prev.x && maxX <= to.x) {
            return true;
        }
        if (maxY <= prev.y && maxY <= to.y) {
            return true;
        }
        return false;

    }

    private static boolean checkAxis(Pos p1, Pos p2) {
        if (p1.x == p2.x || p1.y == p2.y) {
            return false;
        }
        return true;
    }

    private static class Pos implements Comparable<Pos> {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        /*
                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;

                    final Pos pos = (Pos) o;

                    if (x != pos.x) return false;
                    return y == pos.y;
                }

                @Override
                public int hashCode() {
                    int result = x;
                    result = 31 * result + y;
                    return result;
                }
        */
        @Override
        public int compareTo(Pos o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x == o.x) {
                if (this.y > o.y) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return -1;
        }
    }

    private static class Edge implements Comparable<Edge> {
        Pos p1;
        Pos p2;
        double len;

        public Edge(Pos p1, Pos p2) {
            this.p1 = p1;
            this.p2 = p2;
            if (p1.x == p2.x) {
                len = Math.abs(p1.y - p2.y);
            } else if (p1.y == p2.y) {
                len = Math.abs(p1.x - p2.x);
            } else {
                this.len = Math.sqrt(Math.pow((double) p1.x - p2.x, 2) + Math.pow((double) p1.y - p2.y, 2));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Edge edge = (Edge) o;

            if (Double.compare(edge.len, len) != 0) return false;
            if (!p1.equals(edge.p1)) return false;
            return p2.equals(edge.p2);
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = p1 != null ? p1.hashCode() : 0;
            result = 31 * result + (p2 != null ? p2.hashCode() : 0);
            temp = Double.doubleToLongBits(len);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.len > o.len) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
