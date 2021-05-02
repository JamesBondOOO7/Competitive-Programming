s = input()
a = ''.join(s.replace('ZONe', '1'))

count = 0
for ch in a:
    if ch == '1':
        count += 1
        
print(count)