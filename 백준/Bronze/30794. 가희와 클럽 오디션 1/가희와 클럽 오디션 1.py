lv, sign = map(str, input().split())
if sign == 'miss' : 
    print(0)
elif sign == 'bad' : 
    print(200 * int(lv))
elif sign == 'cool' : 
    print(400 * int(lv))
elif sign == 'great' : 
    print(600 * int(lv))
elif sign == 'perfect' : 
    print(1000 * int(lv))