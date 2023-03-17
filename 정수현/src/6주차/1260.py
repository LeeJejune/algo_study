# [BOJ] DFS와 BFS / 실버2 / 50분
# https://www.acmicpc.net/problem/1260

# graph = 그래프를 인접행렬로 표현
# visited = 방문했을 경우 true, 아니면 false
# 1을 더해주지 않으면 out of range
N, M, V = map(int, input().split())
graph = [[0] * (N + 1) for _ in range(N + 1)]
visited_bfs, visited_dfs = [0] * (N + 1), [0] * (N + 1)
bfsList, dfsList = [], []

for _ in range(M):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1


def bfs(v):
    visited_bfs[v] = 1
    queue = [v]

    while queue:
        v = queue.pop(0)
        bfsList.append(v)

        for i in range(1, N + 1):
            if visited_bfs[i] == 0 and graph[v][i] == 1:
                queue.append(i)
                visited_bfs[i] = 1


def dfs(v):
    visited_dfs[v] = 1
    dfsList.append(v)

    for i in range(1, N + 1):
        if visited_dfs[i] == 0 and graph[v][i] == 1:
            dfs(i)

dfs(V)
bfs(V)
print(*dfsList, sep=" ")
print(*bfsList, sep=" ")
