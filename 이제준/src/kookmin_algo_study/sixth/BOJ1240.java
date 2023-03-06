package kookmin_algo_study.sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1240 {
    static int n;
    static ArrayList<Node> list[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, end) + "\n");
        }
        System.out.println(sb);

    }

    static int bfs(int start, int end) {
        visit = new boolean[n + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visit[start] = true;

        int dist = 0;
        
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == end) {
                dist = node.x;
                break;
            }

            for (Node value : list[node.x]) {
                if (!visit[value.x]) {
                    q.offer(new Node(value.x, node.x + value.x));
                    visit[value.x] = true;
                }
            }
        }

        return dist;
    }
}
