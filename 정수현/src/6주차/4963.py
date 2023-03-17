# [BOJ] 섬의 개수 / 실버2 / 40분
# https://www.acmicpc.net/problem/4963

dx = [0, 0, 1, 1, 1, -1, -1, -1]
dy = [1, -1, -1, 0, 1, -1, 0, 1]


def bfs(x, y):
    queue = [(x, y)]
    maps[x][y] = 0

    while queue:
        x, y = queue.pop(0)
        for n in range(8):
            nx = x + dx[n]
            ny = y + dy[n]

            if nx < 0 or nx >= H or ny < 0 or ny >= W:
                continue

            if maps[nx][ny] == 1:
                maps[nx][ny] = 0
                queue.append((nx, ny))


while True:
    W, H = map(int, input().split())
    if W == 0 and H == 0:
        break

    answer = 0
    maps = []
    for _ in range(H):
        maps.append(list(map(int, input().split())))

    for i in range(H):
        for j in range(W):
            if maps[i][j] == 1:
                bfs(i, j)
                answer += 1
    print(answer)
