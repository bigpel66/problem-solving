chicken, coke, beer = map(int, open(0).read().split())
print(min(chicken, coke // 2 + beer))
