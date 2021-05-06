n, l = [int(i) for i in input().split()]
arr = [int(i) for i in input().split()]
arr.sort()
ans = max(arr[0] - 0, l - arr[-1])

for i in range(0,n-1):
    ans = max(ans, (arr[i+1] - arr[i])/2)
        
print(ans)