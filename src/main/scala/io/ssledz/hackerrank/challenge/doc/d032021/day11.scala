package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 11: 2D Arrays
  * https://www.hackerrank.com/challenges/30-2d-arrays/problem
  */
object day11 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    val ps = (0 to 5).flatMap { y =>
      lines.next().split(' ').zipWithIndex.map { case (s, x) => ((x, y), s.toInt) }
    }.toMap

    val dim = (1 to 4).flatMap(i => (1 to 4).map(i -> _)).toList

    def hourglass(ps: Map[(Int, Int), Int])(p: (Int, Int)): Int = p match {
      case (x, y) =>
        ps(p) + ps((x, y + 1)) + ps((x - 1, y + 1)) + ps((x + 1, y + 1)) +
          ps((x, y - 1)) + ps((x - 1, y - 1)) + ps((x + 1, y - 1))
    }

    println(dim.map(hourglass(ps)).max)

  }

}
