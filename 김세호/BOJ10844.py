# 쉬운계단수
# 19:45
# 실패

n = int(input())
num_arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]

for _ in range(n-1) :
    L = len(num_arr)
    for i in range(L) :
        s = str(num_arr[i]%10)
        if (num_arr[i]%10) + 1 > 9 :
            s2 = str(num_arr[i]) + chr(ord(s)-1)
            num_arr.append(int(s2))
            continue
        if (num_arr[i]%10) - 1 < 0 :
            s1 = str(num_arr[i]) + chr(ord(s)+1)
            num_arr.append(int(s1))
            continue
        
        s1 = str(num_arr[i]) + chr(ord(s)+1)
        s2 = str(num_arr[i]) + chr(ord(s)-1)
        num_arr.append(int(s2))
        num_arr.append(int(s1))

    num_arr = num_arr[L:]
    
print(len(num_arr)%1000000000)