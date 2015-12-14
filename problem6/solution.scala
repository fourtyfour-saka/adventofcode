import scala.io.Source
import scala.collection.immutable.StringOps
import scala.collection.mutable.ArrayOps
import Array._
object Solution {
    val lights = tabulate[Int](1000,1000)((_,_) => 0)
    def main(args: Array[String]) = {
        val instrs = Source.fromFile("input.txt").getLines.map { x =>
            x.split(Array(' ', ',')).toList
        }
        instrs foreach { instr => 
            val nI = instr.takeRight(6)
            nI(0) match {
                case "toggle" => toggle(nI(1).toInt, nI(2).toInt, nI(4).toInt, nI(5).toInt)
                case "on"     => turnOn(nI(1).toInt, nI(2).toInt, nI(4).toInt, nI(5).toInt)
                case "off"    =>turnOff(nI(1).toInt, nI(2).toInt, nI(4).toInt, nI(5).toInt)
                case _        => {}
            }
            println(s"Operation: $nI --- \n total brightness ${lights.flatten.sum}") 
        }
        println(lights.flatten.sum)
        // println(instr.takeRight(6))

    }
    def toggle(startX: Int, startY: Int, endX: Int, endY: Int) = {
        for {
            x <- (startX to endX)
            y <- (startY to endY)
        } { lights(x)(y) = lights(x)(y) + 2 }
    }
    def turnOn(startX: Int, startY: Int, endX: Int, endY: Int) = {
        for {
            x <- (startX to endX)
            y <- (startY to endY)
        } { lights(x)(y) = lights(x)(y) + 1 }
    }
    def turnOff(startX: Int, startY: Int, endX: Int, endY: Int) = {
        for {
            x <- (startX to endX)
            y <- (startY to endY)
        } { lights(x)(y) = 0.max(lights(x)(y) - 1) }
    }
}
