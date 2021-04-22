def sortTheArray(a, b, n):
    if a == b:
        print("yes")
        print("1 1")
        return
    
    left, right = 0, 0
    for i in range(n):
        if a[i] != b[i]:
            left = i
            break
            
    for i in range(n-1, -1, -1):
        if a[i] != b[i]:
            right = i
            break
            
    # reverse the portion
    a[left:right+1] = list(reversed(a[left:right+1]))
    
    if a == b:
        print("yes")
        print(f"{left+1} {right+1}")
    
    else:
        print("no")
        
n = int(input())
a = [int(i) for i in input().split()]

b = sorted(a)
sortTheArray(a, b, n)