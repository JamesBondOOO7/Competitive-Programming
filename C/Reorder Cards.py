h,w,n = [int(i) for i in input().split()]

row = []
col = []
xy = []

for e in range(n):
    r,c = [int(i) for i in input().split()]
    row.append((r,e))
    col.append((c,e))
    xy.append((r,c))

row.sort(key = lambda x : x[0])
col.sort(key = lambda x : x[0])

br = {}
prev = row[0][0]
br[row[0][1]] = prev
for i in range(1, n):
    a = row[i][0] - row[i-1][0] + prev
    if row[i][0] != row[i-1][0]:
        a -= 1
    
    br[row[i][1]] = a
    prev = a

bc = {}
prev = col[0][0]
bc[col[0][1]] = prev
for i in range(1, n):

    a = col[i][0] - col[i-1][0] + prev
    if col[i][0] != col[i-1][0]:
        a -= 1

    bc[col[i][1]] = a
    prev = a


# print(br)
# print(bc)

for i in range(n):
    print(f"{xy[i][0] - br[i] + 1} {xy[i][1] - bc[i] + 1}")