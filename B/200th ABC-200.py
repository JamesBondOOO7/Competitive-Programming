n, k = [int(i) for i in input().split()]

for _ in range(k):
    
    if n%200 == 0:
        n = n//200
        
    else:
        n = int(str(n) + "200")
        
print(n)