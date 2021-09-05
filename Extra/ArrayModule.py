# Python lists are slow
# But what if we wanna work with one data type of values only in a list ?

from array import array

#       Type code       C Type                  Minimum size in bytes 
#         'b'         signed integer                1 
#         'B'         unsigned integer              1 
#         'u'         Unicode character             2
#         'h'         signed integer                2 
#         'H'         unsigned integer              2 
#         'i'         signed integer                2 
#         'I'         unsigned integer              2 
#         'l'         signed integer                4 
#         'L'         unsigned integer              4 
#         'q'         signed integer                8
#         'Q'         unsigned integer              8
#         'f'         floating point                4
#         'd'         floating point                8 

arr = array('i', [1,2,3,4])
print(arr)

arr.append(5)
print(arr)

## Sample Question : https://atcoder.jp/contests/abc217/tasks/abc217_d

# CODE : 
import bisect
import sys
from array import array
def get_ints(): return map(int, sys.stdin.readline().strip().split())

class MyList:

    def __init__(self, length):
        self.length = length
        self.cuts = array('i')

    def insert(self, x):
        bisect.insort(self.cuts, x)

    def find(self, x):
        n = len(self.cuts)
        if n == 0:
            print(self.length)
            return

        l = bisect.bisect_left(self.cuts, x)

        if l == 0:
            print(self.cuts[l])

        elif l == n:
            print(self.length - self.cuts[l-1])

        else:
            print(self.cuts[l] - self.cuts[l-1])

l, q = get_ints()

obj = MyList(l)

for j in range(q):
    c, x = get_ints()

    if c == 1:
        obj.insert(x)

    else:
        obj.find(x)