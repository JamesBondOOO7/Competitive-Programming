from collections import namedtuple

# returns a tuple with a named value for each element in the tuple
a = namedtuple('courses', 'name, technology')
s = a('Data Science', 'Python')

print(s)

# Named Tuple Using Lists

s = a._make(['AI', 'Python'])
print(s)