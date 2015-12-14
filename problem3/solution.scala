import scala.io.Source
import scala.collection.immutable.StringOps
import scala.collection.mutable.Map
object Solution {
    def main(args: Array[String]) = {
        val input = Source.fromFile("input.txt").mkString.iterator
        var X = 0
        var Y = 0
        var XR = 0
        var YR = 0
        val presents = Map((0,0) -> 1)
        val robot = Map((0,0) -> 1)
        var turn = "santa"
        while(input.hasNext) {
            input.next match {
                case '^' if turn == "santa" => X = X + 1; presents += ((X,Y) -> (presents.getOrElse((X,Y), 0) + 1))
                case '^' if turn == "robot" => XR = XR + 1; robot += ((XR,YR) -> (robot.getOrElse((XR,YR), 0) + 1))
                case 'v' if turn == "santa" => X = X - 1; presents += ((X,Y) -> (presents.getOrElse((X,Y), 0) + 1))
                case 'v' if turn == "robot" => XR = XR - 1; robot += ((XR,YR) -> (robot.getOrElse((XR,YR), 0) + 1))
                case '<' if turn == "santa" => Y = Y - 1; presents += ((X,Y) -> (presents.getOrElse((X,Y), 0) + 1))
                case '<' if turn == "robot" => YR = YR - 1; robot += ((XR,YR) -> (robot.getOrElse((XR,YR), 0) + 1))
                case '>' if turn == "santa" => Y = Y + 1; presents += ((X,Y) -> (presents.getOrElse((X,Y), 0) + 1))
                case '>' if turn == "robot" => YR = YR + 1; robot += ((XR,YR) -> (robot.getOrElse((XR,YR), 0) + 1))
                case _   => {}
            }
            if(turn == "santa") turn = "robot" else turn = "santa"
        }
        println((presents ++ robot.map{ case (k,v) => k -> (v + presents.getOrElse(k, 0)) }).size)
    }
}
