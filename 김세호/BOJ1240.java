// 노드사이의 거리
// 20:30
// 22:00
// 노드간의 edge는 array list로, edge의 cost는 행렬로 만듦.
// ex)
//   1 2 3 4
// 1 0 2 0 3
// 2 2 0 0 0
// 3 0 0 0 2
// 4 3 0 2 0

// dfs로 돌려서 탐색할때마다 cost행렬에서 값을 꺼내서 count해줌.
// 만약 dfs를 돌리는데 목표지점이 아닌 다른곳으로 갔을 때에 boolean인 falg를 이용하여 다시 돌아오면서 그 cost만큼을 다시 빼줌.

package 김세호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1240 {
    static int n;
    static int m;
    static int cnt;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int cost[][];
    static boolean flag;
    static void dfs(int index, int goal){
        visited[index] = true;

        for(int node : graph[index]){
            if(!visited[node]) {
                cnt += cost[index][node]; // cost를 더해줌
                if(node == goal) { // 목표지점에 도달했을 때
                    flag = true; // flag를 true로
                    return;
                }
                dfs(node, goal);
                if(flag) return; // 목표지점에 돌아가서 재귀함수를 빠져나온거라면 그냥 return
                cnt -= cost[index][node]; // 목표지점이 아닌곳에 도달했다면 재귀함수를 빠져나오면서 cost를 다시 빼줌.
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        
        cost = new int[n+1][n+1];

        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[e1].add(e2);
            graph[e2].add(e1);
            cost[e1][e2] = c;
            cost[e2][e1] = c;
        }
        for(int i=0; i<m; i++){
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            cnt = 0;
            flag = false;
            dfs(e1, e2);
            System.out.println(cnt);
        }
    }
}