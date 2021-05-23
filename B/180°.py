map_dict = {
    '0' : '0',
    '1' : '1',
    '6' : '9',
    '8' : '8',
    '9' : '6'
}

s = input()

ans = []

for i in range(len(s)-1, -1, -1):
    ans.append(map_dict[s[i]])
    
print(''.join(ans))