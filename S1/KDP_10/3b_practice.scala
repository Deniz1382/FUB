def issorted[A](comp : (A,A) => Boolean, list : List[A] ) : Boolean= 
	list match
		case Nil => true
		case x :: Nil => true 
		case x:: y ::xs =>if (comp(x, y)) then issorted(comp, y :: xs) else false
@main def func() : Unit =
	print(issorted((_:Int) > (_:Int), List(4, 3, 1, 2))) 
