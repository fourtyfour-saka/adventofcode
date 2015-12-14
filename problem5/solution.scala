import scala.collection.immutable.StringOps
import scala.io.Source
object Solution {
    def main(args: Array[String]) = {
        val input = Source.fromFile("input.txt").getLines
        println(input.count(newNice(_)))
    }
    def newNice(s: String): Boolean = {
        val pairs = """(..).*\1""".r
        val repeats = """(.).\1""".r
        val opt = for {
          p <- pairs.findFirstIn(s)
          r <- repeats.findFirstIn(s)
        } yield p + r
        !opt.isEmpty
    }
    def nice(s: String): Boolean = {
        // print(s"Testing $s... ")
        val naughtyParts = List("ab", "cd", "pq", "xy")
        val niceParts = "abcdefghijklmnopqrstuvwxyz".toList.map(_.toString * 2)
        var nice = false
        // print("\n\tTesting naughty parts...")
        naughtyParts.foreach { x =>
        if(s.containsSlice(x)) {
            // println(s"Contains $x! :(")
            return false
        }
    }
    // print("\n\tTesting nice parts...")
    niceParts.foreach { x =>
    if(s.contains(x)) {
        // print(s"Contains $x :)")
        nice = true
    }
}
// print("\n\tTesting vowels...")
if(s.count { x => "aeiou".contains(x) } < 3) {
    // println("Not enough vowels!") 
    nice = false
}
// print("\n")
nice
      }
  }

  // vim: set ts=4 sw=4 et:
