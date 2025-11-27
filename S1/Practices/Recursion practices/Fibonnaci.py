def fib (n):
    if n==1:
        return [1]
    elif n==2:
        return [1,1]
    else :
        mylist= fib(n-1)
        mylist.append(mylist[-1]+mylist[-2])    
        return mylist

print(fib(10))