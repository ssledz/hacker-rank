package io.ssledz.hackerrank.fp

/** Pascal's Triangle
  * https://www.hackerrank.com/challenges/pascals-triangle/problem
  */
object ex29 {

  def main(args: Array[String]): Unit = {

    def fact(n: Int): Long = {
      def go(n: Int, acc: Long): Long =
        if (n == 0) acc
        else go(n - 1, acc * n)
      go(n, 1)
    }

    val k = io.Source.stdin.getLines().next().toInt

    def pt(n: Int, r: Int): Long = fact(n) / (fact(r) * fact(n - r))

    (0 until k).foreach { n =>
      println((0 to n).map(r => pt(n, r)).map(_.toString).mkString(" "))
    }

  }

}
