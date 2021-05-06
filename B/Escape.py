vp, vd, t, f, c = [int(input()) for i in range(5)]

if vp >= vd:
    print(0)
    
else:
    curr = vp*t
    count = 0
    while curr < c:
        time = curr/(vd - vp)
        
        if (c-curr)/vp <= time:
            break
            
        curr += (2*time + f)*vp
        count += 1
        
    print(count)