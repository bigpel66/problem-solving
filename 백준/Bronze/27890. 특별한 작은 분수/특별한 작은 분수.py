n, s = map(int, open(0).read().split())
for i in range(s):
    if n % 2 == 0:
        n //= 2
    else:
        n *= 2
    n ^= 6
print(n)
