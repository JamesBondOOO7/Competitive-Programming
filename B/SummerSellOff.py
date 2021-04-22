n,f = [int(i) for i in input().split()]

extra = [] # how much extra that day, we would have earned,
# if we would have doubled the sales
ans = 0

for i in range(n):
    a,b = [int(i) for i in input().split()]
    ans += min(a, b)
    extra_earned = min(2*a, b) - min(a, b)
    extra.append(extra_earned)
    
# sort this extra earned profit in descending order
extra.sort(reverse=True)
for i in range(f):
    ans += extra[i]
    
print(ans)