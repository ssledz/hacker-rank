package io.ssledz.hackerrank.fp

/** Filter Elements
  * https://www.hackerrank.com/challenges/filter-elements/problem
  */
object ex42 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    def nextList: List[Int] = lines.next().split(' ').map(_.toInt).toList

    val t = lines.next().toInt

    def solve(xs: List[Int], k: Int): List[Int] =
      ((Math.pow(10, 9).toInt + 1) :: xs).zipWithIndex
        .sortBy(_._1)
        .foldLeft((-1, 0, 0, List.empty[(Int, Int)])) {
          case ((last, n, i, acc), (x, ii)) if last == x => (last, n + 1, Math.min(i, ii), acc)
          case ((last, n, i, acc), (x, ii))              => (x, 1, ii, if (n >= k) (last, i) :: acc else acc)
        }
        ._4
        .sortBy(_._2)
        .map(_._1)

    def show(xs: List[Int]): String = if (xs.isEmpty) "-1" else xs.mkString(" ")

    (1 to t).foreach { _ =>
      val n :: k :: Nil = nextList
      val a             = nextList
      println(show(solve(a, k)))
    }
  }

}
