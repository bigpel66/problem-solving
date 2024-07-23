A, B = map(int, input().split())
C, D = map(int, input().split())
list1 = [A / C + B / D, C / D + A / B, D / B + C / A, B / A + D / C]
print(list1.index(max(list1)))
