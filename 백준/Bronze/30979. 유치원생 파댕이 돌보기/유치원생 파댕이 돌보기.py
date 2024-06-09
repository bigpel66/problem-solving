T = int(input())
N = int(input())
F = list(map(int, input().split()))
print("Padaeng_i Happy" if T <= sum(F) else "Padaeng_i Cry")