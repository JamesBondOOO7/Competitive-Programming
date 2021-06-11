import bisect

# array should be sorted
a = [24, 33, 41, 41, 45, 50, 53, 59, 62, 66, 70]

# gives the position where to insert the given item
# it will give the index of that item
# if the element which we are gonna insert matches with any element,
# it will give the leftmost suitable value
i = bisect.bisect_left(a, 41)
print(i)

b = [1.3, 2.2, 3.4, 4.6, 5.5, 6.9, 7.2, 8.4]
j = bisect.bisect_left(b, 4.1)
print(j)

c = ["aaa", "bbb", "ccc", "ddd"]
k = bisect.bisect_left(c, "bug")
print(k)
# k = 2  => just before "ccc"

# insort left
# it places the item in the sorted array
d = [24, 33, 41, 41, 45, 50, 53, 59, 62, 66, 70]
bisect.insort_left(d, 44)
print(d)


# bisect right
# gives the position where to insert the given item
# it will give the index of that item
# if the element which we are gonna insert matches with any element,
# it will give the rightmost suitable value
i = bisect.bisect_right(a, 41)
print(i)

b = [1.3, 2.2, 3.4, 4.6, 5.5, 6.9, 7.2, 8.4]
j = bisect.bisect_right(b, 2.2)
print(j)

c = ["aaa", "bbb", "ccc", "ddd"]
k = bisect.bisect_right(c, "dog")
print(k)
# k = 2  => just before "ccc"


# insort right
d = [24, 33, 41, 41, 45, 50, 53, 59, 62, 66, 70]
bisect.insort_right(d, 46)
print(d)

# find an element in a sorted list
def find_next(a, x):

    i = bisect.bisect_right(a, x)

    if i < len(a):
        return a[i]

    return False

print(find_next([10, 15, 20, 25, 30], 33))

def get_grade(score, cutoffs=[60, 70, 80, 90], grades="FDCBA"):

    i = bisect.bisect_right(cutoffs, score)
    return grades[i]

grades = [get_grade(score) for score in [52, 99, 77, 89, 90, 100]]
print(grades)