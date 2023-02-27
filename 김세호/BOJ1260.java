// DFS와 BFS
// 21:50
// 22:20

package 김세호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    static void dfs(int index, boolean visit[], ArrayList<Integer>[] graph){
        visit[index] = true;

        System.out.print(index + " ");

        for(int node : graph[index]){
            if(!visit[node]) {
                dfs(node, visit, graph);
            }
        }
    }
    static void bfs(int index, boolean visit[], ArrayList<Integer>[] graph){
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(index);
        visit[index] = true;
        System.out.print(index + " ");

        while(!q.isEmpty()){
            int n = q.poll();
            
            for(int i : graph[n]){
                if(!visit[i]){
                    q.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean dVisit[] = new boolean[n+1];
        boolean bVisit[] = new boolean[n+1];

        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            graph[e1].add(e2);
            graph[e2].add(e1);
        }

        for(ArrayList<Integer> al : graph){
            Collections.sort(al);
        }

        dfs(v, dVisit, graph);
        System.out.println();
        bfs(v, bVisit, graph);
    }
}