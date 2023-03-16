n = int(input())
price = list(map(int, input().split()))
price = [0] + price

d = price + [0] * (n-len(price))
d[1] = price[1]

for i in range(2, n+1):
    for j in range(1, min(len(price), i)):
        d[i] = max(d[i], price[j] + d[i-j])
        
print(d[i])