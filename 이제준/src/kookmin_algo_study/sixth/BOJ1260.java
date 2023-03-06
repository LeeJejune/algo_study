package kookmin_algo_study.sixth;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
    static int[][] node;
    static boolean[] check;
    static int n, m, v;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        node = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        int a, b;
        for (int i = 1; i <= m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            node[a][b] = node[b][a] = 1;
        }
        dfs(v);
        Resetcheck();
        bfs(v);
    }

    public static void Resetcheck() {
        for (int i = 1; i < n + 1; i++) {
            check[i] = false;
        }
        System.out.println();
    }

    public static void dfs(int d) {
        check[d] = true;
        System.out.print(d + " ");
        for (int i = 1; i < n + 1; i++) {
            if (node[d][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int b) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(b);
        check[b] = true;
        while (!queue.isEmpty()) {
            b = queue.poll();
            System.out.print(b + " ");
            for (int i = 1; i < n + 1; i++) {
                if (node[b][i] == 1 && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                }
            }
        }
    }
}

