N, D, H = [int(i) for i in input().split()]

ans = 0
for i in range(N):
    d, h = [int(i) for i in input().split()]
    
    x = (h*D - H*d)/(D-d)
    ans = max(x, ans)

print(ans)