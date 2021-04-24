def swap(arr, brr, i, j, n):
    
    if i<n and j<n:
        arr[i], arr[j] = arr[j], arr[i]
        
    elif i<n and j>=n:
        j -= n
        arr[i], brr[j] = brr[j], arr[i]
        
    elif i>=n and j>=n:
        i -= n
        j -= n
        brr[i], brr[j] = brr[j], brr[i]
        

n = int(input())
s = input()

arr = []
brr = []

for i in range(n):
    arr.append(s[i])
    brr.append(s[n+i])

q = int(input())
arrFirst = True

for i in range(q):
    
    t,a,b = [int(i)-1 for i in input().split()]

    if t == 0:
        if arrFirst:
            swap(arr, brr, a, b, n)
            
        else:
            swap(brr, arr, a, b, n)
    
    else:
        arrFirst = not arrFirst
        
if arrFirst:
    for ele in arr:
        print(ele , end="")
        
    for ele in brr:
        print(ele , end="")
        
else:
    for ele in brr:
        print(ele , end="")
        
    for ele in arr:
        print(ele , end="")
        