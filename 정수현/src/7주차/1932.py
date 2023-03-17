# [BOJ] 정수 삼각형 / 실버1 / X
# https://www.acmicpc.net/problem/1932
# https://velog.io/@bye9/%EB%B0%B1%EC%A4%80%ED%8C%8C%EC%9D%B4%EC%8D%AC-1932-%EC%A0%95%EC%88%98-%EC%82%BC%EA%B0%81%ED%98%95

n = int(input())
tri = []
for _ in range(n):
    tri.append(list(map(int, input().split())))

# 0번째 줄은 계산X
for i in range(1, n):
    for j in range(len(tri[i])):
        if j == 0:
            tri[i][j] += tri[i - 1][0]
        elif j == len(tri[i]) - 1:
            tri[i][j] += tri[i - 1][len(tri[i - 1]) - 1]
        else:
            tri[i][j] += max(tri[i - 1][j - 1], tri[i - 1][j])

print(max(tri[n - 1]))
