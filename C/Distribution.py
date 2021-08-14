n = int(input())

S = [int(i) for i in input().split()]
T = [int(i) for i in input().split()]

min_val = 10**10
idx = 0
for i, ele in enumerate(T):
    if ele < min_val:
        min_val = ele
        idx = i

ans = [0]*n

ans[idx] = T[idx]
temp = idx
idx = (idx + 1) % n
while idx != temp:
    ti = ( (idx - 1) + n ) % n
    ans[idx] = min(ans[ti] + S[ti], T[idx])
    idx = (idx + 1) % n

for ele in ans:
    print(ele)