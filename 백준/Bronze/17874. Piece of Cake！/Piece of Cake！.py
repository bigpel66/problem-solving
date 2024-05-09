N, W, H = map(int, input().split())
print(max(N - W, W) * max(N - H, H) * 4)
