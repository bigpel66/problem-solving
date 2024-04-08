l = list(map(int, input().split()))
S, K, H = l
if sum(l) >= 100:
    print("OK")
    exit(0)
val = min(l)
if val == S:
    print("Soongsil")
elif val == K:
    print("Korea")
elif val == H:
    print("Hanyang")
