# [BOJ] 가장 긴 감소하는 부분 수열 / 실버2 / X
# https://www.acmicpc.net/problem/11722
# https://dndi117.tistory.com/34

N = int(input())
A = list(map(int, input().split()))
dp = [1 for _ in range(N)]

# A[j] > A[i]이면 감소하므로 문제 조건 만족
for i in range(N):
    for j in range(i):
        if A[j] > A[i]:
            # 기존값과 이전의 최대값인 dp[j]에 1을 더한 값 중 최대값 저장
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))
