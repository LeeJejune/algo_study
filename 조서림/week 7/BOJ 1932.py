n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, len(a)):
    row = a[i]
    for j in range(len(row)):
        if j == 0:
            a[i][j] += a[i-1][j]
        elif j == len(row) - 1:
            a[i][j] += a[i-1][j-1]
        else:
            a[i][j] += max(a[i-1][j-1], a[i-1][j])
        
print(max(a[n-1]))