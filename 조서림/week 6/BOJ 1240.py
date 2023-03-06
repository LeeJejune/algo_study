import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    x, y, k = map(int, sys.stdin.readline().split())
    tree[x].append((y, k))
    tree[y].append((x, k))

def bfs(v):
    queue = deque([(v, 0)])
    visited = [False] * (n+1)
    visited[v] = True
    
    while len(queue) > 0:
        curr, dist = queue.popleft()
        if curr == target: return dist
        
        for next, d in tree[curr]:
            if not visited[next]:
                queue.append((next, d+dist))
                visited[next] = True

for _ in range(m):
    start, target = map(int, sys.stdin.readline().split())
    print(bfs(start))