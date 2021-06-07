n = int(input())

a = [int(i) for i in input().split()]

ans = 0
for i in a:
    
    if i>10:
        ans += (i - 10)
        
print(ans)