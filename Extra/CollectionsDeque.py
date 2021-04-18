from collections import deque
# optimized list to perform insertion and deletion easily

a = [ch for ch in "helloWorld"]

d = deque(a)
print(d)

# addLast
d.append('python')
print(d)

# addFirst
d.appendleft('java')
print(d)

# removeLast
d.pop()
print(d)

# removeFirst
d.popleft()
print(d)