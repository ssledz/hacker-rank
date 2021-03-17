package io.ssledz.hackerrank.fp

/** Super-Queens on a Chessboard
  * https://www.hackerrank.com/challenges/super-queens-on-a-chessboard/problem
  */
object ex39 {

  type Point = (Int, Int)

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    val n = lines.next().toInt

    def beats(q1: Point, q2: Point): Boolean = (q1, q2) match {
      case ((x1, y1), (x2, y2)) =>
        val dx = Math.abs(x1 - x2)
        val dy = Math.abs(y1 - y2)
        x1 == x2 || y1 == y2 ||
        (dx == 1 && dy == 2) ||
        (dy == 1 && dx == 2) ||
        (dy == dx)
    }

    def solve(size: Int): Int = {
      def go(n: Int): List[List[Point]] =
        if (n == 0) List(List.empty)
        else
          for {
            qs <- go(n - 1)
            y  <- 1 to size
            q = (n, y)
            if !qs.exists(qq => beats(q, qq))
          } yield q :: qs

      go(size).size

    }

    println(solve(n))
  }
}
