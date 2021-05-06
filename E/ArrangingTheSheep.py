t = int(input())
for _ in range(t):
    n = int(input())
    l = input()
    c=0
    left=[]
    right=[]
    for i in l:
        if i =='*':
            c+=1
        left.append(c)
    c=0
    for i in l[::-1]:
        if i=='*':
            c+=1
        right.append(c)
    right=right[::-1]
    ans=0
    for i in range(len(l)):
        if l[i]=='.':
            ans+=min(left[i],right[i])
    print(ans)