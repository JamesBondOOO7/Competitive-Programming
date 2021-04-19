t = int(input())

for i in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    
    found = False
    for ele in a:
        
        if ele**0.5 - int(ele**0.5) != 0:
            print("YES")
            found = True
            break
            
    if found == False:
        print("NO")