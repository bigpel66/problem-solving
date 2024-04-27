o = open(0)
trial = int(o.readline())
l = [list(map(int, o.readline().split())) for _ in range(trial)]
ans = 10e4
for i in l:
    if i[0] <= i[1]:
        ans = min(ans, i[1])
print(ans if ans != 10e4 else -1)
