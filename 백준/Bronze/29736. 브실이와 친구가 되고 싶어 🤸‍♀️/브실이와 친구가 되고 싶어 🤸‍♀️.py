A, B = map(int, input().split())
K, X = map(int, input().split())
count = 0
for i in range(K-X, K+X+1) : 
    if B >= i >= A: 
        count += 1
print("IMPOSSIBLE" if count == 0 else count)
