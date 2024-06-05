trial = int(input())
result = 0
for _ in range(trial):
    w, _ = map(int, input().split())
    if w == 136:
        result += 1000
    elif w == 142:
        result += 5000
    elif w == 148:
        result += 10000
    elif w == 154:
        result += 50000
print(result)
