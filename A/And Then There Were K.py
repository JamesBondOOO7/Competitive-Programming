# n & (n−1) & (n−2) & (n−3) & ... (k) = 0
t = int(input())
for i in range(t):
    n = int(input())
    ans = 0
    idx = 0
    while True:
        
        n = n>>1
        if n == 0:
            break
        ans += 1<<idx
        
        idx += 1
        
    print(ans)