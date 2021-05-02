t = int(input())

for i in range(t):
    n = int(input())
    u = [int(i) for i in input().split()]
    s = [int(i) for i in input().split()]
    teams = {}
    for i in range(n):
        if u[i] not in teams:
            teams[u[i]] = []
            
        teams[u[i]].append(s[i])
        
    for key in teams:
        teams[key].sort(reverse=True)
    
    for key in teams:
        score = []
        temp = 0
        
        for i,ele in enumerate(teams[key]):
            temp += ele
            score.append(temp)
        teams[key] = score
    
    ans = [0 for i in range(n)]
    k = 1

    for key in teams:
        
        score = teams[key]
        le = len(score)
        for k in range(1, le + 1):

            rem = len(teams[key]) % k
                
            if rem == 0:
                ans[k-1] += score[-1]
                
            else:
                l = len(teams[key]) - rem - 1
                ans[k-1] += score[l]
        
    for ele in ans:
        print(ele , end=" ")
    print()