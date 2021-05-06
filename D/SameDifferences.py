t = int(input())

for q in range(t):
    n = int(input())
    arr = [int(i) for i in input().split()]
    
    for i in range(n):
        arr[i] -= i
        
    num_maps = {}
    
    for ele in arr:
        if ele not in num_maps:
            num_maps[ele] = 0
            
        num_maps[ele] += 1
        
    ans = 0
    
    for val in num_maps.values():
        ans += val*(val-1)//2
            
    print(ans)