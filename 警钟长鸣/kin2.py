import pandas as pd
import numpy as np
from collections import Counter

address = 'E:\Artikel\Kin-Ball Superturnier - gespielt Spiele.xlsx'  # path
table = pd.read_excel(address)

colnames1 = table.iloc[1:, 1].values.tolist()
colnames2 = table.iloc[1:, 2].values.tolist()
colnames3 = table.iloc[1:, 3].values.tolist()
pkt1 = list(map(int, table.iloc[1:, 4].values.tolist()))
pkt2 = list(map(int, table.iloc[1:, 5].values.tolist()))
pkt3 = list(map(int, table.iloc[1:, 6].values.tolist()))
abz1 = list(map(int, table.iloc[1:, 7].values.tolist()))
abz2 = list(map(int, table.iloc[1:, 8].values.tolist()))
abz3 = list(map(int, table.iloc[1:, 9].values.tolist()))
vlgr = table.iloc[1:, 10].values.tolist()

platz1 = []
platz2 = []
platz3 = []
names_li = []
platz_li = []
zidian = {}
for i in range(len(colnames1)):
    if pkt1[i] > pkt2[i] and pkt1[i] > pkt3[i]:
        platz1.append(13 + abz1[i])
        names_li.append(colnames1[i])
        platz_li.append(platz1[i])
        if pkt2[i] > pkt3[i]:
            platz2.append(6 + pkt2[i] + abz2[i])
            names_li.append(colnames2[i])
            platz_li.append(platz2[i])
            platz3.append(2 + pkt3[i] + abz3[i])
            names_li.append(colnames3[i])
            platz_li.append(platz3[i])
            print(colnames1[i], platz1[i], ',', colnames2[i], platz2[i], ',', colnames3[i], platz3[i])
        elif pkt3[i] > pkt2[i]:
            platz2.append(6 + pkt3[i] + abz3[i])
            names_li.append(colnames3[i])
            platz_li.append(platz2[i])
            platz3.append(2 + pkt2[i] + abz2[i])
            names_li.append(colnames2[i])
            platz_li.append(platz3[i])
            print(colnames1[i], platz1[i], ',', colnames3[i], platz2[i], ',', colnames2[i], platz3[i])
        else:
            if vlgr[i] == colnames2[i]:
                platz2.append(6 + pkt2[i] + abz2[i])
                names_li.append(colnames2[i])
                platz_li.append(platz2[i])
                platz3.append(2 + pkt3[i] + abz3[i])
                names_li.append(colnames3[i])
                platz_li.append(platz3[i])
                print(colnames1[i], platz1[i], ',', colnames2[i], platz2[i], ',', colnames3[i], platz3[i])
            elif vlgr[i] == colnames3[i]:
                platz2.append(6 + pkt3[i] + abz3[i])
                names_li.append(colnames3[i])
                platz_li.append(platz2[i])
                platz3.append(2 + pkt2[i] + abz2[i])
                names_li.append(colnames2[i])
                platz_li.append(platz3[i])
                print(colnames1[i], platz1[i], ',', colnames3[i], platz2[i], ',', colnames2[i], platz3[i])
    elif pkt2[i] > pkt1[i] and pkt2[i] > pkt3[i]:
        platz1.append(13 + abz2[i])
        names_li.append(colnames2[i])
        platz_li.append(platz1[i])
        if pkt1[i] > pkt3[i]:
            platz2.append(6 + pkt1[i] + abz1[i])
            names_li.append(colnames1[i])
            platz_li.append(platz2[i])
            platz3.append(2 + pkt3[i] + abz3[i])
            names_li.append(colnames3[i])
            platz_li.append(platz3[i])
            print(colnames2[i], platz1[i], ',', colnames1[i], platz2[i], ',', colnames3[i], platz3[i])
        elif pkt3[i] > pkt1[i]:
            platz2.append(6 + pkt3[i] + abz3[i])
            names_li.append(colnames3[i])
            platz_li.append(platz2[i])
            platz3.append(2 + pkt1[i] + abz1[i])
            names_li.append(colnames1[i])
            platz_li.append(platz3[i])
            print(colnames2[i], platz1[i], ',', colnames3[i], platz2[i], ',', colnames1[i], platz3[i])
        else:
            if vlgr[i] == colnames1[i]:
                platz2.append(6 + pkt1[i] + abz1[i])
                names_li.append(colnames1[i])
                platz_li.append(platz2[i])
                platz3.append(2 + pkt3[i] + abz3[i])
                names_li.append(colnames3[i])
                platz_li.append(platz3[i])
                print(colnames2[i], platz1[i], ',', colnames1[i], platz2[i], ',', colnames3[i], platz3[i])
            elif vlgr[i] == colnames3[i]:
                platz2.append(6 + pkt3[i] + abz3[i])
                names_li.append(colnames3[i])
                platz_li.append(platz2[i])
                platz3.append(2 + pkt1[i] + abz1[i])
                names_li.append(colnames1[i])
                platz_li.append(platz3[i])
                print(colnames2[i], platz1[i], ',', colnames3[i], platz2[i], ',', colnames1[i], platz3[i])
    elif pkt3[i] > pkt1[i] and pkt3[i] > pkt2[i]:
        platz1.append(13 + abz3[i])
        names_li.append(colnames3[i])
        platz_li.append(platz1[i])
        if pkt2[i] > pkt1[i]:
            platz2.append(6 + pkt2[i] + abz2[i])
            names_li.append(colnames2[i])
            platz_li.append(platz2[i])
            platz3.append(2 + pkt1[i] + abz1[i])
            names_li.append(colnames1[i])
            platz_li.append(platz3[i])
            print(colnames3[i], platz1[i], ',', colnames2[i], platz2[i], ',', colnames1[i], platz3[i])
        elif pkt1[i] > pkt2[i]:
            platz2.append(6 + pkt1[i] + abz1[i])
            names_li.append(colnames1[i])
            platz_li.append(platz2[i])
            platz3.append(2 + pkt2[i] + abz2[i])
            names_li.append(colnames2[i])
            platz_li.append(platz3[i])
            print(colnames3[i], platz1[i], ',', colnames1[i], platz2[i], ',', colnames2[i], platz3[i])
        else:
            if vlgr[i] == colnames2[i]:
                platz2.append(6 + pkt2[i] + abz2[i])
                names_li.append(colnames2[i])
                platz_li.append(platz2[i])
                platz3.append(2 + pkt1[i] + abz1[i])
                names_li.append(colnames1[i])
                platz_li.append(platz3[i])
                print(colnames3[i], platz1[i], ',', colnames2[i], platz2[i], ',', colnames1[i], platz3[i])
            elif vlgr[i] == colnames1[i]:
                platz2.append(6 + pkt1[i] + abz1[i])
                names_li.append(colnames1[i])
                platz_li.append(platz2[i])
                platz3.append(2 + pkt2[i] + abz2[i])
                names_li.append(colnames2[i])
                platz_li.append(platz3[i])
                print(colnames3[i], platz1[i], ',', colnames1[i], platz2[i], ',', colnames2[i], platz3[i])

print("Teams' points and winning games rank:")
for i in range(len(names_li)):
    if names_li[i] in zidian.keys():
        for j in range(len(zidian)):
            keys_li = list(zidian.keys())
            values_li = list(zidian.values())
            if names_li[i] == keys_li[j]:
                zidian[keys_li[j]] = values_li[j] + platz_li[i]
    else:
        zidian.update({names_li[i]: platz_li[i]})  # 合并两个list，然后现在是一一对应的600个，我们试一下合并关键字分数
rank = dict(sorted(zidian.items(), key=lambda x: x[1], reverse=True))


dic1 = dict(zip(colnames1, pkt1))
dic2 = dict(zip(colnames2, pkt2))
dic3 = dict(zip(colnames3, pkt3))
for i in range(len(colnames1)):
    if colnames1[i] in dic1.keys():
        for j in range(len(dic1)):
            if colnames1[i] == colnames1[j]:
                dic1[colnames1[j]] = pkt1[j] + pkt1[i]
    else:
        dic1.update({colnames1[i]: pkt1[i]})
for i in range(len(colnames2)):
    if colnames2[i] in dic2.keys():
        for j in range(len(dic2)):
            if colnames2[i] == colnames2[j]:
                dic2[colnames2[j]] = pkt2[j] + pkt2[i]
    else:
        dic2.update({colnames2[i]: pkt2[i]})
for i in range(len(colnames3)):
    if colnames3[i] in dic3.keys():
        for j in range(len(dic3)):
            if colnames3[i] == colnames3[j]:
                dic3[colnames3[j]] = pkt3[j] + pkt3[i]
    else:
        dic3.update({colnames3[i]: pkt3[i]})
X, Y, Z = Counter(dic1), Counter(dic2), Counter(dic3)
dic = dict(X+Y+Z)


keys_li = list(rank.keys())
values_li = list(rank.values())
pktkeys_li = list(dic.keys())
pktvalues_li = list(dic.values())
for i in range(len(keys_li)):
    for j in range(len(pktkeys_li)):
        if pktkeys_li[j] == keys_li[i]:
            print(i+1, keys_li[i], ':', values_li[i], 'win:', pktvalues_li[j])

teamname = input("Enter team name:")
pos = np.where(np.array(names_li) == teamname)[0]
new_li = []
for j in range(len(pos)):
    a = pos[j]
    new_li.append(platz_li[a])
result = sum(new_li)

print("The team's point is", result)

# listx = []
# for i in range(nrows):
#   colnames1[i]


# lis = list(cell1,cell2,cell3)
# lis.sort()
# platz1 = 10+3+abz1
# if (lis[2] != lis[3]):
#   platz2 = 6+lis[2]+abz2
#   platz3 = 2+lis[3]+abz3
#   elif vlgr_gew
