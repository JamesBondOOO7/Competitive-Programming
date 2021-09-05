n = int(input())
p = [int(i) for i in input().split()]

q = [0]*n

for i,ele in enumerate(p):
    q[ele - 1] = i+1

print(*q)