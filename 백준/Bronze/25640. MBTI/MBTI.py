answer = input()
trial = int(input())
l = [input() for _ in range(trial)]
count = 0
for i in l:
    if answer == i:
        count += 1
print(count)
