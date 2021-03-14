package io.ssledz.hackerrank.fp

/** Compute the Perimeter of a Polygon
  * https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon/problem
  */
object ex24 extends App {

  type Point = (Int, Int)

  def perimeter(xs: List[Point]): Double =
    (xs.tail ++ List(xs.head))
      .foldLeft((0.0, xs.head)) { case ((acc, (x1, y1)), p @ (x2, y2)) =>
        val rx = Math.pow(x2 - x1, 2)
        val ry = Math.pow(y2 - y1, 2)
        (acc + Math.sqrt(rx + ry), p)
      }
      ._1

  val lines = io.Source.stdin.getLines()
  val n     = lines.next().toInt
  def pointFrom(xs: List[Int]): Point = xs match {
    case x :: y :: Nil => (x, y)
  }
  val xs = List.fill(n)(pointFrom(lines.next().split(' ').map(_.toInt).toList))
  println(perimeter(xs))

}
