import scala.util.Random


class Skiplist(val maxlevel : Int = 10)
	//Node Define
	class Node(val key:Int, val value: Int, val level: Int) :
		val forward: Array[Node] = new Array[Node](level + 1)	
	val head = new Node(Int.MinValue, 0 , maxlevel)

//find random level for each node	
	def randomLevel() : Int=
		val p : Double = 0.5 
		val rand = new scala.util.Random()
		var level :Int = 0
		while rand.nextDouble() < p && level < maxlevel do
			level+=1
		level 
	def search(k: Int): Array[Node] =
		val Q = new Array[Node](maxlevel + 1)
		var n = head
		var level = maxlevel
		while level >= 0 do
			while n.forward(level) != null && n.forward(level).key < k do
				n = n.forward(level)
			Q(level) = n
			level -= 1
		Q


	



//val testrandomlevel: Int = randomLevel()  

//@main def test() : Unit =
//	println(s"Test $testrandomlevel" )


