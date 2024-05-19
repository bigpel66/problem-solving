stamp, price = map(int, open(0).read().split())
discount = [0]
if stamp >= 5:
    discount.append(500)
if stamp >= 10:
    discount.append(price // 10)
if stamp >= 15:
    discount.append(2000)
if stamp >= 20:
    discount.append(price // 4)
print(max(price - max(discount), 0))
