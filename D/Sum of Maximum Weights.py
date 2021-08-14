class Solution:

    def __init__(self, n, edges):
        edges.sort(key=lambda x : x[2])
        # print(edges)
        parent = [[i,1] for i in range(n+1)]
        
        ans = 0
        for e in edges:
            p0 = self.findParent(e[0], parent)
            p1 = self.findParent(e[1], parent)

            size1 = parent[p0][1]
            size2 = parent[p1][1]
            ans += size1 * size2 * e[2]

            # union
            parent[p0][0] = p1
            parent[p1][1] += parent[p0][1]

        # print(parent)
        print(ans)


    def findParent(self, i, parent):

        if parent[i][0] == i:
            return i

        parent[i][0] = self.findParent(parent[i][0], parent)
        return parent[i][0]

if __name__ == '__main__':

    n = int(input())
    
    edges = []

    for i in range(1, n):
        edges.append([int(i) for i in input().split()])

    sol = Solution(n, edges)