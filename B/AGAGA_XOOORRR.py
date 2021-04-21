t = int(input())

for i in range(t):
    
    n = int(input())
    a = ([int(i) for i in input().split()])
    xor_arr = 0
    for ele in a:
        xor_arr = xor_arr ^ ele
    
    if xor_arr == 0 :
        print("YES")
        
    else:
        count = 0
        xor = 0
        for ele in a:
            xor = xor ^ ele

            if xor == xor_arr:
                count += 1
                xor = 0

        if count >= 2 and xor == 0:
            print("YES")

        else:
            print("NO")