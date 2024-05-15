trial = int(input())
l = [list(map(int, input().split())) for _ in range(trial)]
for i, e in enumerate(l):
    print(f"Case #{i + 1}: {max(e)}")
