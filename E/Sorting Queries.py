import heapq
from collections import deque

q = int(input())

deq = deque()
heap = []

for _ in range(q):
    
    a = [int(i) for i in input().split()]
    
    if a[0] == 1:
        deq.append(a[1])
        
    elif a[0] == 2:
        
        if len(heap) != 0:
            print(heapq.heappop(heap))  # remove top of heap
            
        else:
            print(deq.popleft())
            
    else:
        while len(deq) != 0:
            heapq.heappush(heap, deq.pop())