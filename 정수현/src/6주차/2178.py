# [BOJ] 미로 탐색 / 실버1 / 30분
# https://www.acmicpc.net/problem/2178

N, M = map(int, input().split())
maze = []

for _ in range(N):
    line = []
    for j in input():
        line.append(int(j))
    maze.append(line)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = [(x, y)]

    while queue:
        x, y = queue.pop(0)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            if maze[nx][ny] == 1:
                maze[nx][ny] = maze[x][y] + 1
                queue.append((nx, ny))

    return maze[N-1][M-1]


print(bfs(0, 0))
