from collections import Counter

# dictionary subclass for counting hashable objects

a = [1,1,2,3,2,2,4,1,1,2,3,4,5,6,6,3,3]
c = Counter(a)
print(c)

# returns a dict ( value : it's count )

# list of all the elements in the counter
print(list(c.elements()))

# Sorted list with (Value,count) as the elements
# Note: Sorted according to count ( Decreasing )
# If clash occurs : less value is preferred
print(c.most_common())

# Subtracting the frequency of elements
sub = {2:1, 6:3}
print(c.subtract(sub))
print(c.most_common())