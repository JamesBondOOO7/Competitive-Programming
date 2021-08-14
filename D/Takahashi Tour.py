import sys
sys.setrecursionlimit(300000)

class Solution:

    def __init__(self, n, graph):
        self.ans = []
        self.DFS(1, graph, -1)

        print(*self.ans)

    def DFS(self, node, graph, prev):

        self.ans.append(node)
        for nbr in graph[node]:

            if prev != nbr:
                self.DFS(nbr, graph, node)
                self.ans.append(node)

    
if __name__ == "__main__":

    n = int(input())

    graph = [[] for i in range(n+1)]

    for i in range(n-1):
        u, v = [int(i) for i in input().split()]

        graph[u].append(v)
        graph[v].append(u)

    for i in range(n+1):
        graph[i].sort()

    # print(graph)
    sol = Solution(n, graph)