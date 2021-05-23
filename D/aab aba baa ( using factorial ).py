def fact(n):
    
    if n <= 1:
        return 1
    
    fact = 1
    for i in range(2, n+1):
        fact *= i
        
    return fact

a, b, k = [int(i) for i in input().split()]
ans = ""
while a>0 and b>0:
    
    temp1 = fact(a+b-1)//(fact(a-1) * fact(b)) # a first
    
    if temp1 < k:
        ans += "b"
        b -= 1
        k -= temp1
        
    elif temp1 >= k:
        ans += "a"
        a -= 1
        
ans += "a"*a + "b"*b
print(ans)