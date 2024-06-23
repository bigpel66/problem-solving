trial = int(input())
levels = map(int, input().split())
intervals = []
for i in levels:
    if i == 300:
        intervals.append("1")
    elif i >= 275:
        intervals.append("2")
    elif i >= 250:
        intervals.append("3")
    else:
        intervals.append("4")
print(' '.join(intervals))
