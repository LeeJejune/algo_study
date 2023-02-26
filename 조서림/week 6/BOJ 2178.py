import sys

n, m = map(int, sys.stdin.readline().split())
maze = [list(map(int, list(sys.stdin.readline().strip()))) for _ in range(n)]

def bfs():
    queue = [(0, 0, 1)]
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True
    directions = [(-1,0),(1,0),(0,-1),(0,1)]
    
    while queue:
        x, y, dist = queue.pop(0)
        
        if x == n-1 and y == m-1: return dist
        
        for dx, dy in directions:
            a = x+dx
            b = y+dy
            if (0 <= a < n and 0 <= b < m) and maze[a][b] == 1 and not visited[a][b]:
                visited[a][b] = True
                queue.append((a, b, dist+1))
                
print(bfs())