t = int(input())

for i in range(t):
    n = int(input())
    u = [int(i) for i in input().split()]
    s = [int(i) for i in input().split()]
    team = {}
    for i in range(n):
        if u[i] not in team:
            team[u[i]] = []
            
        team[u[i]].append(s[i])
        
    for key in team:
        team[key].sort(reverse=True)
        
    ans = []
    
    score_map = {}
    for key in team:
        score_map[key] = []
        temp = 0
        
        for i,ele in enumerate(team[key]):
            temp += ele
            score_map[key].append(temp)
    
    k = 1
    while( k<=n ):
        temp = 0
        for key in team:
            
            if len(team[key]) < k:
                temp += 0
                
            else:
                rem = len(team[key]) % k
                if rem == 0:
                    temp += score_map[key][-1]
                    
                else:
                    l = len(team[key]) - rem - 1
                    temp += score_map[key][l]
                    
        if temp == 0:
            break
        ans.append(temp)
            
        k += 1
        
    for i in range(k, n+1):
        ans.append(0)
        
    for ele in ans:
        print(ele , end=" ")
    print()