import java.security.MessageDigest
import scala.util.Random

// define a class for each node, now with nonce
case class Node(data: String, nextHash: String, nonce: Int)

// get the input and convert to hash hexadecimal output using SHA-256
def sha256(input: String): String =
  val digest = MessageDigest.getInstance("SHA-256")
  val hashBytes = digest.digest(input.getBytes("UTF-8"))
  hashBytes.map("%02x".format(_)).mkString

// check if hash ends with 8 zero bits in binary (last byte == 0)
def isValidHash(hex: String): Boolean =
  if hex.length < 2 then false
  else
    val lastByte = Integer.parseInt(hex.takeRight(2), 16)
    lastByte == 0

// find a nonce such that sha256(data + nextHash + nonce) ends with 8 zero bits
def mineHash(data: String, nextHash: String): (String, Int) =
  var nonce = 0
  var hash = ""
  while !isValidHash(hash)
    do
    nonce = Random.nextInt(Int.MaxValue)
    hash = sha256(data + nextHash + nonce.toString)
  (hash, nonce)

// append a new value to the list, with mining
def append(list: List[Node], value: String): List[Node] =
  list match
    case Nil =>
      List(Node(value, "", 0)) // genesis block, no mining needed

    case x :: Nil =>
      val (nextHash, nonce) = mineHash(value, "")
      val newNode = Node(value, "", nonce)
      val updatedHead = x.copy(nextHash = nextHash)
      List(updatedHead, newNode)

    case x :: xs =>
      x :: append(xs, value)

@main def test(): Unit =
  val list0 = List.empty[Node]
  val list1 = append(list0, "A")
  val list2 = append(list1, "B")
  val list3 = append(list2, "C")

    list3.foreach { n =>
    if n.nextHash.nonEmpty then
        val binaryHash = BigInt(n.nextHash, 16).toString(2).padTo(256, '0')
        val last8Bits = binaryHash.takeRight(8)

        println(s"Data: ${n.data}")
        println(s"Nonce: ${n.nonce}")
        println(s"NextHash (hex): ${n.nextHash}")
        println(s"NextHash (bin): ...${last8Bits}")
        println(s"Ends with 8 zero bits? " + (last8Bits == "00000000"))
        println("-" * 40)
    else
        println(s"Data: ${n.data}")
        println(s"Nonce: ${n.nonce}")
        println("NextHash: (empty — last node)")
        println("-" * 40)
}


