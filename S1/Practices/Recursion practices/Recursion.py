#ye adad chan raghami migire va tabdil be char mikone

def tabdil (a:int):
    j = a
    if a<10:
        print(a,"\n")
        return j
    else:
       j=tabdil(a//10)
       print(a%10,"\n")

tabdil(1234)

