for t in range(int(input())):
    n = int(input())
    s = input()
    
    count = 0
    for ch in s:
        if ch == '0':
            count += 1
            
    if count == 1 or count % 2 == 0:
        print("BOB")
        
    elif count % 2 == 1:
        print("ALICE")
        
    else:
        print("DRAW")