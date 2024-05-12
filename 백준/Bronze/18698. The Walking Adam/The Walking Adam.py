trial = int(input())
for _ in range(trial):
    count = 0
    for i in input():
        if i == "D":
            break
        count += 1
    print(count)
