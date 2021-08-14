n = int(input())
x = [int(i) for i in input().split()]
arr = []

for i in range(n):
    arr.append((x[i], i+1))

arr.sort(key=lambda x : x[0])

print(arr[n-2][1])