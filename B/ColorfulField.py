n, m, k, t = [int(i) for i in input().split()]

waste_map = {}
for i in range(n):
    waste_map[i] = []
    
for q in range(k):
    i, j = [int(i)-1 for i in input().split()]
    waste_map[i].append(j)

# print(waste_map)
fruit_map = {
    -1 : "Waste",
    0 : "Carrots",
    1 : "Kiwis",
    2 : "Grapes"
}

starts = [0]*n
num = 0
for i in range(n):
    starts[i] = num
    num = ( num + m - len(waste_map[i]) ) % 3
    
# print(starts)
for q in range(t):
    i, j = [int(i)-1 for i in input().split()]
    
    ans = -1
    
    if j not in waste_map[i]:
        count = 0
        for ele in waste_map[i]:
            if ele < j:
                count += 1
        
        ans = (starts[i] + j - count) % 3
        
    print(fruit_map[ans])