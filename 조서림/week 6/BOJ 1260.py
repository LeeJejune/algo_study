import sys

n, m, v = map(int, sys.stdin.readline().split())
nodes = [[0] * (n+1) for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    nodes[x][y] = nodes[y][x] = 1

def dfs(visited, v):
    if not visited[v]:
        print(v, end=' ')
        visited[v] = True
    
    for i in range(1, n+1):
        if nodes[v][i] == 1 and not visited[i]:
            dfs(visited, i)

def bfs(v):
    visited = [False] * (n+1)
    visited[v] = True
    queue = [v]
    
    while len(queue) > 0:
        curr = queue.pop(0)
        print(curr, end=' ')
        
        for i in range(1, n+1):
            if nodes[curr][i] == 1 and not visited[i]:
                queue.append(i)
                visited[i] = True
            
visited = [False] * (n+1)
dfs(visited, v)
print()
bfs(v)