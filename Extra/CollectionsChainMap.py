from collections import ChainMap
# A single view for multiple mappings
a = {1:'python',
    2:'java',
}

b = {
    3:'ML',
    4:'Android'
}

cmap = ChainMap(a, b)
print(cmap)