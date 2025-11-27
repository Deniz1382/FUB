import java.security.MessageDigest

case class Node(data: String, nextHash: String)

/** Compute SHA-256 hash of the input string and return it as hex. */
def sha256(input: String): String =
  val digest = MessageDigest.getInstance("SHA-256")
  val bytes = digest.digest(input.getBytes("UTF-8"))
  bytes.map("%02x".format(_)).mkString

/** Append a new value to the list, updating hashes. */
def append(list: List[Node], value: String): List[Node] = list match
  case Nil => List(Node(value, ""))
  case x :: Nil =>
    val newNode = Node(value, "")
    val updatedHead = x.copy(nextHash = sha256(newNode.data + newNode.nextHash))
    List(updatedHead, newNode)
  case x :: xs =>
    x :: append(xs, value)

@main def test(): Unit =
  val list0 = List.empty[Node]
  val list1 = append(list0, "A")
  val list2 = append(list1, "B")
  val list3 = append(list2, "C")
  println(list3)