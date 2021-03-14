package io.ssledz.hackerrank.fp

/** Compute the Area of a Polygon
  * https://www.hackerrank.com/challenges/lambda-march-compute-the-area-of-a-polygon/problem
  */
object ex25 extends App {

  type Point = (Int, Int)

  // https://www.mathsisfun.com/geometry/area-irregular-polygons.html
  def area(xs: List[Point]): Double = {
    (xs.tail ++ List(xs.head))
      .foldLeft((0.0, xs.head)) { case ((acc, (x1, y1)), p @ (x2, y2)) =>
        val avgH = (y1 + y2) / 2.0
        val w    = x1 - x2
        (acc + w * avgH, p)
      }
      ._1
  }

  val lines = io.Source.stdin.getLines()
  val n     = lines.next().toInt
  def pointFrom(xs: List[Int]): Point = xs match {
    case x :: y :: Nil => (x, y)
  }

  val xs = List.fill(n)(pointFrom(lines.next().split(' ').map(_.toInt).toList))

  println(area(xs))

}
