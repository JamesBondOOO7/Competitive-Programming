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