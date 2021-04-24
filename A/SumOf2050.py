def div2050(n):
    
    if n<2050:
        return -1
    
    if n%2050 == 0:
        num = n//2050
        
        count = 0
        while num != 0:
            count += num % 10
            num = num//10
            
        return count
    
    else:
        return -1
    
n = int(input())
for i in range(n):
    num = int(input())
    print(div2050(num))