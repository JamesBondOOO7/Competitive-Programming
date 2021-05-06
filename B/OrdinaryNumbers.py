# My Approach
def func(n):
    ans = 0
    for ch in "123456789":
        temp = ch
        while int(temp) <= n:
            ans += 1    
            temp += ch
            
    return ans
    
t = int(input())

for i in range(t):
    n = int(input())
    print(func(n))

    
# Better Approach

# for _ in range(int(input())):
#     n=int(input())
#     l=len(str(n))
#     ans=(l-1)*9
#     for i in range(1,10):
#         if int(str(i)*l)<=n:
#             ans+=1
#         else:
#             break
#     print(ans)