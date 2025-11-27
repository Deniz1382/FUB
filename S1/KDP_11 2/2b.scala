def sumSmaller[T : Numeric](w : T, list : List[T]): T = 
    val num = summon[Numeric[T]] 
    import num._
    list match
        case Nil => zero 
        case x :: Nil => if (x < w) then x else zero
        case x :: y :: xs => if(x < w) then  x +  sumSmaller(w,y :: xs) else sumSmaller(w, y :: xs)

@main def func() : Unit =
    println(sumSmaller(5, List(1, 6, 3 , 7, 2, 7, 8)))