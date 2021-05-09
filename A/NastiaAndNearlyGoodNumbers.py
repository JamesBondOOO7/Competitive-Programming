for _ in range(int(input())):
    
    a,b = [int(i) for i in input().split()]
    if b == 2:
        b *= 2
        
    if b == 1:
        print("NO")
    
    elif b%2 == 0:
        x = a*(b-1)
        y = a
        z = a*b
        print("YES")
        print(x, y, z)
        
    else:
        q = b//2
        x = a*(q)
        y = a*(b - q)
        z = a*b
        print("YES")
        print(x, y, z)