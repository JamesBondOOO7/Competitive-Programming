a, b, c = sorted([int(i) for i in input().split()])

if c - b == b - a:
    print("Yes")
    
else:
    print("No")