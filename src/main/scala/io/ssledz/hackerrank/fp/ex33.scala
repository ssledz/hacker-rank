package io.ssledz.hackerrank.fp

/** Functions and Fractals - Recursive Trees
  * https://www.hackerrank.com/challenges/fractal-trees/problem
  */
object ex33 {

  type Point = (Int, Int)

  implicit class PointOps(val p: Point) extends AnyVal {
    def +(other: Point): Point = (other._1 + p._1, other._2 + p._2)
  }

  def main(args: Array[String]): Unit = {

    val n = io.Source.stdin.getLines().next().toInt
    val h = 63
    val w = 100

    def makeTree(pos: Point, len: Int): (Point, Point, Set[Point]) = {
      val (x, y)   = pos
      val vertical = (0 until len).map(c => x -> (y - c))
      val ds       = 1 to len
      val c        = vertical.last
      val left     = ds.map(d => c + (-d, -d))
      val right    = ds.map(d => c + (d, -d))
      (left.last + (0, -1), right.last + (0, -1), (vertical ++ left ++ right).toSet)
    }

    def iterate(n: Int): Set[Point] = {
      def go(n: Int, len: Int, p: Point): Set[Point] = {
        if (n == 0) Set.empty[Point]
        else {
          val (p1, p2, tree) = makeTree(p, len)
          tree ++ go(n - 1, len / 2, p1) ++ go(n - 1, len / 2, p2)
        }
      }

      go(n, 16, ((w - 1) / 2, h - 1))
    }

    def show(xs: Set[Point]): String = {
      (0 until h)
        .map { y =>
          (0 until w).map { x =>
            if (xs.contains(x -> y)) "1" else "_"
          }.mkString
        }
        .mkString("\n")
    }

    println(show(iterate(n)))

  }
}
