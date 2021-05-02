n, m = [int(i) for i in input().split()]

res = []
poss = True
for i in range(n):
    
    row = [ch for ch in input()]
    
    c = 0
    d = 0
    for i,ch in enumerate(row):
        
        if ch == 'G':
            d = i
            
        elif ch == 'S':
            c = i
            
    dist = c - d -1
    if dist < 0:
        poss = False
        break
        
    res.append(dist)

if poss:
    print(len(set(res)))
    
else:
    print(-1)