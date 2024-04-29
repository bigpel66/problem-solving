W, H = map(int, open(0).read().split())
print(0 if W % 2 == 0 or H % 2 == 0 else min(W, H))
