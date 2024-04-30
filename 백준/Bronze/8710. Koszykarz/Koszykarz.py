from math import ceil

C, T, U = map(int, open(0).read().split())
print(ceil((T - C) / U))
