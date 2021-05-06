from collections import deque
# deque : is a Linked List
# stack
print("Stack")
a = deque()
# O(1) addFirst
for i in range(5):
    a.appendleft(i)
    print(a, f"Top of stack : {a[0]}") # Top of stack

# O(1) removeFirst
while len(a) != 0:
    x = a.popleft()
    print(a, f"Popped Element : {x}")


# Queue
print("Queue")
b = deque()
# O(1) addLast
for i in range(5):
    b.append(i)
    print(b)

print(f"Front of the queue : {b[0]}")

# O(1) removeFirst
while len(b) != 0:
    x = b.popleft()
    front = -1 if len(b) == 0 else b[0] # Ternary in python
    print(b, f"new front : {front}")


# Min Heap
print("Min Heap")
import heapq
li = [4,7,1,2,5]

# Converts the list to a heap
heapq.heapify(li)

print(type(li))

# pushing elements in the heap
heapq.heappush(li, 3)
print(li)
heapq.heappush(li, -1)
print(li)

# popping elements from the heap
heapq.heappop(li)
print(li)
heapq.heappop(li)
print(li)