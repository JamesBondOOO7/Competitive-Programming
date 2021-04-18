from collections import OrderedDict
# remembers the order in which the entries were done

d = OrderedDict()
for i,ch in enumerate("HelloWorld"):
    d[i+1] = ch

print(d)

# Keys
print(d.keys())

# Values
print(d.items())

# The features are same as dictionaries