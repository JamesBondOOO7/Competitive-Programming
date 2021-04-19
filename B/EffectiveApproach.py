def petya(a):
    comp = 1
    strg = {}
    for i in range(len(a)-1, -1, -1):
        strg[a[i]] = comp
        comp += 1

    return strg

def vasya(a):
    comp = 1
    strg = {}
    for i in range(0, len(a)):
        strg[a[i]] = comp
        comp += 1

    return strg

n = int(input())
a = [int(i) for i in input().split()]

q = int(input())
m = [int(i) for i in input().split()]

n1 = 0
n2 = 0

strg1 = vasya(a)
strg2 = petya(a)

for num in m:

    if num in strg1:
        n1 += strg1[num]
        n2 += strg2[num]
    
    else:
        n1 += n
        n2 += n

print(f"{n1} {n2}")