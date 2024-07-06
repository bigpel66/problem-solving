n = int(input()) - 1
row = n // 8 + 1
col = n % 8
print(chr(ord("a") + col) + str(row))
