def makePalin(s, n):
    
    count = 0
    for i in range(0, n//2 + 1):
        if s[i] != s[n-1-i]:
            if s[i] == '1':
                s[n-1-i] = '1'
            else:
                s[i] = '1'
            count += 1
            
    return s, count

for i in range(int(input())):
    n = int(input())
    s = [c for c in input()]
    s, cost = makePalin(s, n)
    
    # now the string is Palindrome
    # we will apply the same formula
    
    if cost == 0:  # already plaindrome, same as easy
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
            
    else:
        count = 0
        for ch in s:
            if ch == '0':
                count += 1
                
        if count == 1 and cost == 1:  # 01011
            print("DRAW")
            
        else:  # 110, 1010, 001011, 0010011
            print("ALICE")
                
