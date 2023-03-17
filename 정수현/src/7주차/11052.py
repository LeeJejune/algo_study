# [BOJ] 카드 구매하기 / 실버1 / 40분
# https://www.acmicpc.net/problem/11052

N = int(input())
p = list(map(int, input().split()))
p.insert(0, 0)
dp = [0 for _ in range(N + 1)]

# dp[1] = p[1]
# dp[2] = max(dp[1] + p[1], dp[0] + p[2])
# dp[3] = max(dp[2] + p[1], dp[1] + p[2], dp[0] + p[3])
# dp[4] = max(dp[3] + p[1], dp[2] + p[2], dp[1] + p[3], dp[0] + p[4])
# ...
# dp[i] = max(dp[i], dp[i - j] + p[j])

for i in range(1, N + 1):
    for j in range(1, i + 1):
        dp[i] = max(dp[i], dp[i - j] + p[j])

print(dp[N])
