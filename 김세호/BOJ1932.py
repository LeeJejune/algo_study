# 정수삼각형

n = int(input())

nums = [] * n

for i in range(n):
    nums.append(list(map(int, input().split())))

for i in range(1, n):
    if i == 1 :
        nums[1][0] += nums[0][0]
        nums[1][1] += nums[0][0]
    else :
        for j in range(len(nums[i])):
            if j==0 :
                nums[i][0] +=nums[i-1][0]
            elif j==len(nums[i])-1 :
                nums[i][j] += nums[i-1][j-1]
            else :
                nums[i][j] += max(nums[i-1][j-1], nums[i-1][j])

print(max(nums[n-1]))