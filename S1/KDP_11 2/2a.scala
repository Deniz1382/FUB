//not completed

def issorted[A](comp : (A,A)=> Boolean,list : List[A] ) : Boolean= 
    def tailhelp(helper : Boolean, list : List [A]): Boolean = 
        list match
            case Nil => helper
            case x :: Nil => helper 
            case x:: y ::xs => tailhelp(helper && comp(x, y),y :: xs)
    tailhelp(true,list)
@main def func() : Unit =
    print(issorted((_:Int) < (_:Int),List(4,5,8,3,2,4))) 
