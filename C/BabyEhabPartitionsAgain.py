n = int(input())
a = [int(i) for i in input().split()]

total = sum(a)

# if the sum is odd
if total%2 != 0:
    print(0)
    
else:
    
    # check using Knapsack, if the partition exits
    dp = [False] * ( total//2 + 1)
    dp[0] = True
    
    for i in range(n):
        for j in range(len(dp)-1, -1, -1):
            if dp[j] and j + a[i] < len(dp):
                dp[j + a[i]] = True
                
    if dp[ total//2 ] == False:
        print(0)
        
    else:
        print(1)
        
        while True:
            found = False
            
            for i in range(n):
                
                if a[i] % 2 == 1:
                    print(i+1)
                    found = True
                    break
                    
                a[i] = a[i] // 2
                
            if found:
                break