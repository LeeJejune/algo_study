import sys
sys.setrecursionlimit(10**6)

while True:
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0: break
    land = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]
    
    check = [[False] * w for _ in range(h)]
    directions = [(-1,0),(-1,-1),(0,-1),(1,-1),(1,0),(1,1),(0,1),(-1,1)]
    
    def dfs(x, y):
        if land[x][y] == 1 and not check[x][y]:
            check[x][y] = True
        
        for dx, dy in directions:
            a = x+dx
            b = y+dy
            if (0 <= a < h and 0 <= b < w) and land[a][b] == 1 and not check[a][b]:
                dfs(a, b)
    
    cnt = 0    
    for i in range(h):
        for j in range(w):
            if land[i][j] == 1 and not check[i][j]:
                dfs(i, j)
                cnt += 1
    print(cnt)