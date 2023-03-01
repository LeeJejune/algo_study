package kookmin_algo_study.sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visit = new boolean[n][m];
        visit[0][0] = true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(nextY < 0 || nextX < 0 || nextX >= n || nextY >= m){
                    continue;
                }
                if (visit[nextX][nextY] || map[nextX][nextY] == 0){
                    continue;
                }
                queue.add(new Node(nextX, nextY));
                map[nextX][nextY] = map[node.x][node.y] + 1;
                visit[nextX][nextY] = true;
            }
        }
    }

}
class Node{
    int x;
    int y;

    public Node(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}


