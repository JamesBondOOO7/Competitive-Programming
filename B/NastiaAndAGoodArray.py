for _ in range(int(input())):
    n = int(input())
    arr = [int(i) for i in input().split()]

    print(n//2)
    
    i = 0
    while i<n-1:
        
        min_ele = min(arr[i], arr[i+1])
        if arr[i] > arr[i+1]:
            arr[i], arr[i+1] = arr[i+1], arr[i]
            
        arr[i+1] = 10**9 + 7
        print(i+1, i+2, min_ele,10**9 + 7)
        i += 2