t = int(input())
CONST = (10**9 + 7)
for i in range(t):
    n, k = [int(i) for i in input().split()]
    ans = n**k
    print(ans % CONST)