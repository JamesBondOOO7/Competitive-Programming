t = int(input())

for i in range(t):
    n,m,k = [int(i) for i in input().split()]
    
    if n*m - 1 == k:
        print("YES")
        
    else:
        print("NO")