n = int(input())
trial = list(map(int, input().split()))
pre = 0
sum = 0
for i in trial:
    if i == 1:
        pre += 1
    else:
        pre = 0
    sum += pre
print(sum)
