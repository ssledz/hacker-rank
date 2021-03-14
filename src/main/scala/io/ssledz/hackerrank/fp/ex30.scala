package io.ssledz.hackerrank.fp

/** Functions and Fractals: Sierpinski triangles
  * https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangles/problem
  */
object ex30 {

  def main(args: Array[String]): Unit = {

    type Point = (Int, Int)

    val n    = io.Source.stdin.getLines().next().toInt
    val rows = 32
    val cols = 63

    def show(xs: Set[Point]): String = {
      (0 until rows)
        .map { y =>
          (0 until cols).map { x =>
            if (xs.contains(x -> y)) "1" else "_"
          }.mkString
        }
        .mkString("\n")
    }

    def move(d: Point, xs: Set[Point]): Set[Point] = d match {
      case (dx, dy) => xs.map { case (x, y) => (x + dx, y + dy) }
    }

    def flip(xs: Set[Point]): Set[Point] = {
      val maxY = xs.map(_._2).max
      xs.map { case (x, y) => (x, maxY - y) }
    }

    def fractal(w: Int, h: Int): Set[Point] = {
      (0 until h)
        .foldLeft((-w / 2, w - w / 2 - 1, Set.empty[Point])) { case ((x1, x2, acc), y) =>
          val ps = (x1 to x2).map(_ -> y)
          (x1 + 1, x2 - 1, acc ++ ps)
        }
        ._3
    }

    def iterate(n: Int): Set[Point] = {
      def it(n: Int, w: Int, h: Int, mid: Point): Set[Point] = {
        if (n == 0) Set.empty
        else {
          val (midX, midY) = mid
          val fr           = fractal(w / 2, h / 2)
          move((midX, midY + h / 2), fr) ++ it(n - 1, w / 2, h / 2, (midX - w / 4 - 1, midY + h / 2)) ++
            it(n - 1, w / 2, h / 2, (midX + w / 4 + 1, midY + h / 2)) ++
            it(n - 1, w / 2, h / 2, (midX, midY + h / 64))
        }
      }
      move((cols / 2, 0), flip(fractal(cols, rows))) -- it(n, cols, rows, (cols / 2, 0))
    }

    println(show(iterate(n)))

  }

}
