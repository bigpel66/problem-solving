import sys
input = sys.stdin.readline
for _ in range(3) :
    t = int(input())
    hap = 0
    for i in range(t) :
        hap += int(input())
    if hap == 0 :
        print('0')
    elif hap > 0 :
        print('+')
    else :
        print('-')