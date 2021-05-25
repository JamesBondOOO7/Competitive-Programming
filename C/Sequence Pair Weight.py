for _ in range(int(input())):
    
    n = int(input())
    
    a = [int(i) for i in input().split()]
    
    map_dict = {}
    
    for i,ele in enumerate(a):
        
        if ele not in map_dict:
            map_dict[ele] = [i]
            
        else:
            map_dict[ele].append(i)
            
    
    ans = 0
    for ele in map_dict:
        idxs = map_dict[ele]
        
        temp = n - idxs[-1]
        for i in range(len(idxs)-2, -1, -1):
            # print(i, ans)
            ans += (idxs[i] + 1)*(temp)
            temp += (n - idxs[i])
            
    print(ans)