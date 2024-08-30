import sys
input = sys.stdin.readline
n = int(input())
score_A, score_B = 0, 0
for _ in range(n):
    a, b = map(int, input().split())
    if a > b: score_A += 1
    elif a < b: score_B += 1
print(score_A, score_B)