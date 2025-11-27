import scala.io.Source
import scala.io.StdIn.readLine


def readFromUrl(url: String): String =
    Source.fromURL(url)("UTF-8").mkString

def countPatternMatch(textlist : List[Char], patternlist : List[Char]): Int =
    textlist match
        case Nil => 0
        case _ if textlist.length < patternlist.length => 0
        case x :: xs => if (isMatch(textlist,patternlist)) 1 + countPatternMatch(xs, patternlist) else  countPatternMatch(xs,patternlist)


def isMatch(textlist : List[Char], patternlist : List[Char]) : Boolean =
    (textlist,patternlist) match 
        case (_,Nil) => true 
        case (Nil,_) => false
        case (x :: xs, p :: ps) => if (x == p) isMatch(xs,ps) else false




@main def main(): Unit =
  //println("Enter URL of the text file:")
  //val url = readLine()
  //val text = readFromUrl(url)
  val text : String = "Call me Ishmael. The whale is a mighty creature. A whale swims fast. I saw a Whale once. WhalEs are huge."
  val cleanText = text.toLowerCase.replaceAll("[^a-z]", "")
  val textlist: List[Char] = cleanText.toList
  println("Enter the Pattern:")
  val pattern = readLine()
  val patternlist: List[Char] = pattern.toList
  val result = countPatternMatch(textlist,patternlist).toString()
  println(s"The pattern '$pattern' appears $result times.")

