enum Booleans:
    case Truem
    case Falsem
    case Not (sth : Booleans)
    case Or (l : Booleans, r : Booleans)
    case And (l : Booleans, r : Booleans)

def evaluation(x : Booleans) : Boolean =
    import Booleans.*
    x match
        case Truem => true
        case Falsem => false
        case Not (sth)=> if (evaluation(sth) == false) true else false
        case Or (l,r) => evaluation(l) match
                            case true => true
                            case false => if (evaluation(r) == true) true else false 
        case And (l,r) => evaluation(l) match
                            case true => if (evaluation(r) == true) true else false
                            case false =>  false 

@main def func() : Unit=
    import Booleans.*
    println(evaluation(And(Not(Falsem),Truem)).toString)