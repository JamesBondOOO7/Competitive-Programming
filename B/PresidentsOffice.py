n, m, color = [i for i in input().split()]
n = int(n)
m = int(m)

matrix = []

for i in range(n):
    row = [ch for ch in input()]
    matrix.append(row)

found = False
start = []
end = []
for i in range(n):
    for j in range(m):
        if matrix[i][j] == color:
            if found == False:
                start = [i, j]
                end = [i, j]
                found = True
                
            else:
                end = [i, j]
                

unique = set()
# check the row above
if start[0] >= 1:
    for i in range(start[1], end[1] + 1):
        unique.add(matrix[start[0] - 1][i])
    
# check the row below
if end[0] < n-1:
    for i in range(start[1], end[1] + 1):
        unique.add(matrix[end[0] + 1][i])
        
# check the column in the left
if start[1] >= 1:
    for i in range(start[0], end[0] + 1):
        unique.add(matrix[i][start[1]-1])
        
# check the column in the right
if end[1] < m-1:
    for i in range(start[0], end[0] + 1):
        unique.add(matrix[i][end[1] + 1])
        
if '.' in unique:
    unique.remove('.')
    
print(len(unique))