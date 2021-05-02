n,m = [int(i) for i in input().split()]

match = []
for i in range(m):
    match.append([int(j) for j in input().split()])

match.sort(key=lambda a : a[1], reverse=True)
ans = 0
idx = 0
while idx<m and n>0:

    ans += match[idx][1]*(min(n, match[idx][0]))
    n -= match[idx][0]
    idx += 1

print(ans)