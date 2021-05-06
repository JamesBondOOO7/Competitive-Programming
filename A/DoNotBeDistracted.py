q = int(input())

for t in range(q):
    n = int(input())
    tasks = input()
    
    prev = None
    order = set()
    follow = True
    for task in tasks:
        
        if task != prev:
            
            if task in order:
                print("NO")
                follow = False
                break
                
            order.add(task)
            prev = task
            
    if follow:
        print("YES")