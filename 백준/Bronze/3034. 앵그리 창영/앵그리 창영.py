n, w, h = map(int, input().split())
z = ((w ** 2 + h ** 2) ** (0.5))

for i in range(n):
    box = int(input())
    if box <= z:
        print("DA")
    else:
        print("NE")