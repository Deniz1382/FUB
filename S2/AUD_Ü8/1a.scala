import java.security.MessageDigest

def sha256(input: String): String = {
  val sha256 = MessageDigest.getInstance("SHA-256")
  val hashBytes = sha256.digest(input.getBytes("UTF-8"))
  hashBytes.map("%02x".format(_)).mkString
}
