import java.security.MessageDigest
import scala.collection.immutable.StringOps
object Solution {
  def main(args: Array[String]) = {
    val digest = MessageDigest.getInstance("MD5")

    val key = "ckczppom"
    var solved = false
    var salt = 0
    while (!solved) {
      salt = salt + 1
      val crypto = key + salt.toString
      print(s"Digesting key $crypto...")
      val bits = digest.digest(crypto.getBytes).map("%02x".format(_)).mkString
      if(bits.take(6) == "000000")
          solved = true
      println(s" Done. (First 6 chars: ${bits.take(6)})")
    }
    println(salt)
  }
}

// vim: set ts=4 sw=4 et:
