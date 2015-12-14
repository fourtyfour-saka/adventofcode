import scala.io.Source
import scala.collection.immutable.StringOps
object Solution {
  def main(args: Array[String]): Unit = {
    val lines = Source.fromFile("input.txt").getLines.toList.map(_.split('x').toList)
    println(lines.foldLeft(0){ (res, cur) =>
      res + ribbon(cur.map(_.toInt))
    })
  def surface(hlw: List[Int]): Int = {
    val height = hlw(0)
    val length = hlw(1)
    val width  = hlw(2)
    val hl = height * length
    val lw = length * width
    val wh = width * height
    2 * hl + 2 * lw + 2 * wh + List(hl, lw, wh).min 
  }
  def ribbon(hlw: List[Int]): Int = {
    val height = hlw(0)
    val length = hlw(1)
    val width =  hlw(2)
    val hlp = 2 * (height + length)
    val lwp = 2 * (length + width)
    val whp = 2 * (width + height)
    List(hlp,lwp,whp).min + height * length * width
  }

}
}
