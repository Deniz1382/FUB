import scala.util.Random

//define Skiplist class
class Skiplist(val maxLevel: Int = 10):
//define Node class
	class Node(val key: Int, var value: Int, val lvl: Int):
		val forward: Array[Node] = new Array[Node](lvl + 1)
// head and end as first and last node 
	val head = new Node(Int.MinValue, -1, maxLevel)
	val end  = new Node(Int.MaxValue, 999999, maxLevel)
// find a raandom level for each node
	def randomLevel(): Int =
		val p = 0.5
		val rand = new scala.util.Random()
		var lvl = 0
		while rand.nextDouble() < p && lvl < maxLevel do
			lvl += 1
		lvl
//helper for insertion and deletion to search for the nodes on path to k 
	def search(k: Int): Array[Node] =
		val Q = new Array[Node](maxLevel + 1)
		var n = head
		var lvl = maxLevel
		while lvl >= 0 do
			while n.forward(lvl) != null && n.forward(lvl).key < k do
				n = n.forward(lvl)
			Q(lvl) = n
			lvl -= 1
		Q
//insertion with help of search and random level	
	def insert(k: Int, v: Int): Unit =
		val update = search(k)
		var current = update(0).forward(0)

		if current != null && current.key == k then
			current.value = v
			return

		val lvl = randomLevel()
		val newNode = new Node(k, v, lvl)

		for i <- 0 to lvl do
			newNode.forward(i) = update(i).forward(i)
			update(i).forward(i) = newNode

//deletion with help of search 
	def delete(k: Int): Unit =
		val update = search(k)
		var current = update(0).forward(0)
		if current != null && current.key == k then
			for i <- 0 to maxLevel do
				if update(i).forward(i) == current then
				update(i).forward(i) = current.forward(i)
				return
				



val sl = new Skiplist()
val testrandomlevel: Int = sl.randomLevel()  

@main def test() : Unit =
	println(s"Test $testrandomlevel" )


