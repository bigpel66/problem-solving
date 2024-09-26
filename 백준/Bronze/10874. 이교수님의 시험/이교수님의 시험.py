for _ in range(int(input())):
    tmp = list(map(int, input().split()))
    cnt = 0
    for i in range(10):
        if tmp[i] == (i + 1) % 5: 
            cnt += 1
    if cnt == 8: 
        print(_ + 1)