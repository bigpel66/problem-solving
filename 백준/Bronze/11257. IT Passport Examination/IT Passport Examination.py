num = int(input()) 
for i in range(num):
    a, b, c, d = map(int, input().split())
    ss = b + c + d
    s = ""
    if ss < 55:
        s = f"{a} {ss} FAIL"
    elif b / 35 < 0.3:
        s = f"{a} {ss} FAIL"
    elif c / 25 < 0.3:
        s = f"{a} {ss} FAIL"
    elif d / 40 < 0.3:
        s = f"{a} {ss} FAIL"
    elif d / 40 >= 0.3 and c / 25 >= 0.3 and b / 35 >= 0.3:
        s = f"{a} {ss} PASS"
    print(s)