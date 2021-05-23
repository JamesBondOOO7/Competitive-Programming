n = int(input())

a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i)-1 for i in input().split()]

a_dict = {}
for ele in a:
    
    if ele not in a_dict:
        a_dict[ele] = 1
        
    else:
        a_dict[ele] += 1
        
c_dict = {}
for ele in c:
    
    if ele not in c_dict:
        c_dict[ele] = 1
        
    else:
        c_dict[ele] += 1
    
ans = 0
for ele in c_dict:
    
    if b[ele] in a_dict:
        mul = c_dict[ele]
        ans += mul*a_dict[b[ele]]
        
    # print(ele, ans)
        
print(ans)