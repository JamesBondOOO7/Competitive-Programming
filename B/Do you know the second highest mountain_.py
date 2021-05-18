n = int(input())

peaks = []
for i in range(n):
    a, b = [i for i in input().split()]
    peaks.append((int(b), a))
    
peaks.sort(key=lambda x : x[0], reverse=True)
print(peaks[1][1])