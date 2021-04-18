# Global variables in python example
l = 10 # global
print("Global Variable : l = {}".format(l))
def func1(n):
    l = 5 # local
    m = 7 # local
    print(l, m)
    print(n, "Something...")

func1("Hello")

# First func1() checks for l in the local scope
# if not found, then it goes for global scope

def func2():
    print(l)
    print("Hey!!")

func2()

# In this, l is not present in the local scope,
# then, l will be searched in the global scope

# We can't change the value of local variable in any function

# def func3():

#     l = l + 30
#     print("Global Variable Changed : l = {}".format(l))

# func3()

# This gives error : " local variable 'l' referenced before assignment "

# Thus, in functions, the variable is read only !!

# But we can use a reserved keyword to change the value of the global variable

def func4():
    global l
    l = l + 20
    print(l)

func4()
print(f"Global Variable (changed) : l = {l}")

# Nested Functions Scenario

def f1():

    x = 20

    def f2():
        global x
        x = 55

    print(f"Before Calling f2(), x = {x}")
    f2()
    print(f"After Calling f2(), x = {x}")

f1()

# x didn't change, but why?
# because, global x meant that
# - check in the global scope, and not inside any other function

# But how to access x declared in f1() ?
# Using the nonlocal keyword

def f1_():

    x = 20

    def f2_():
        nonlocal x
        x = 55

    print(f"Before Calling f2_(), x = {x}")
    f2_()
    print(f"After Calling f2_(), x = {x}")

f1_()