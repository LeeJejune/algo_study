# [BOJ] 노드사이의 거리 / 골드5 / X
# https://www.acmicpc.net/problem/1240
# https://jie0025.tistory.com/152

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]


def bfs(x, y):
    queue = [(x, 0)]
    visited = [False] * (N + 1)
    visited[x] = True

    while queue:
        a, b = queue.pop(0)

        if a == y:
            return b

        for i, d in graph[a]:
            if not visited[i]:
                visited[i] = True
                queue.append((i, b + d))


for _ in range(N - 1):
    n1, n2, d = map(int, input().split())
    graph[n1].append((n2, d))
    graph[n2].append((n1, d))

for _ in range(M):
    t1, t2 = map(int, input().split())
    print(bfs(t1, t2))
