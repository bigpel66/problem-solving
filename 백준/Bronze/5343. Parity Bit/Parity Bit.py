for _ in range(int(input())):
    parity = list(input())
    cnt = len(parity) // 8
    error = 0
    for i in range(cnt):
        if parity[i * 8:(i + 1) * 8].count("1") % 2 == 1:
            error += 1
    print(error)
