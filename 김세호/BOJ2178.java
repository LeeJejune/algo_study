// 미로탐색
// 17:20
// 19:00

// 위치를 꺼내기 위해 Point 클래스 사용.

package 김세호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point; 

public class BOJ2178 {
    static char arr[][];
    static int n;
    static int m;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static void bfs(int goal_x, int goal_y){
        Queue<Point> q = new LinkedList<Point>(); // bfs를 위한 Queue
        int cnt = 1;
        q.add(new Point(0, 0));
        arr[0][0] = '0';

        while(!q.isEmpty()){
            int len = q.size(); 

            for(int l=0; l<len; l++){ // bfs로 탐색할때 같은 level(한 좌표에서 갈 수 있는 모든 위치들)에 있는 위치를 중복으로 count하지 않기 위해 queue의 length만큼 돌려줌
                Point p = q.poll();
                int X = p.x;
                int Y = p.y;
                for(int i=0; i<4; i++){
                    int nx = X + dx[i];
                    int ny = Y + dy[i]; // 상하좌우를 탐색
        
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
        
                    if(arr[nx][ny] == '0') continue;
        
                    if(nx == goal_x-1 && ny == goal_y-1){
                        System.out.print(cnt+1);
                        return;
                    }
    
                    q.add(new Point(nx, ny));
        
                    arr[nx][ny] = '0';
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        bfs(n, m);
    }
}