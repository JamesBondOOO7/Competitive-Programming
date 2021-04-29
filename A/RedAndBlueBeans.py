def redAndBlue(r, b, d):
    
    if d == 0:
        if r == b:
            return "YES"
        else:
            return "NO"
        
    small = min(r, b)
    big = r + b - small
    
    if (1 + d)*small >= big:
        return "YES"
    
    return "NO"

t = int(input())

for i in range(t):
    r,b,d = [int(i) for i in input().split()]
    print(redAndBlue(r, b, d))