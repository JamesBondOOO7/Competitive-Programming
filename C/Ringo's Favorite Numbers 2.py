n = int(input())

a = [int(i) for i in input().split()]

num_map = {}

for val in a:
    ele = val % 200
    
    if ele not in num_map:
        num_map[ele] = 0
        
    num_map[ele] += 1
    
k = 0

for ele in num_map.values():
    
    k += ele*(ele-1)//2
    
print(k)