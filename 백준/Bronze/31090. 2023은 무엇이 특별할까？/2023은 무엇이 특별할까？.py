trial = int(input())
l = [int(input()) for _ in range(trial)]
for i in l:
    print(["Bye", "Good"][(i + 1) % (i % 100) == 0])
