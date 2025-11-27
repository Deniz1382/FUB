import java.security.MessageDigest

//define a class for each node 
case class Node(data: String, nextHash : String) //used case class for authomate object define with "new"

//get the input and convert to hash hexadecimal output in method SHA-256
def sha256(input: String): String = 
  val digest = MessageDigest.getInstance("SHA-256")
  val hashBytes = digest.digest(input.getBytes("UTF-8"))
  hashBytes.map("%02x".format(_)).mkString

//append a new value,while updating the previous hash
def append(list : List [Node],value: String) : List[Node] =
  list match
    case Nil => List(Node(value,""))  //when the list is empty
    case x :: Nil => 
      val newNode = Node(value, "")  //make thhe the Node whithout nextHhash
      val updatedHead = x.copy(nextHash = sha256(newNode.data + newNode.nextHash)) //update nexthash in last existing node
      List(updatedHead, newNode)
    case x :: xs => x :: append(xs, value) //reach tthe last list



@main def test(): Unit =
  val list0 = List.empty[Node]
  val list1 = append(list0, "A")
  val list2 = append(list1, "B")
  val list3 = append(list2, "C")
  println(list3)

