package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 10: Binary Numbers
  * https://www.hackerrank.com/challenges/30-binary-numbers/problem
  */
object day10 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt

    def binary(n: Int): String = {
      def go(n: Int, acc: String): String =
        if (n == 0) acc
        else go(n / 2, (n % 2).toString + acc)
      go(n, "")
    }

    def solve(s: String): Int = {
      def go(xs: scala.List[Char], max: Int, acc: Int): Int = xs match {
        case h :: t if h == '1' => go(t, max, acc + 1)
        case h :: t if h == '0' => go(t, Math.max(max, acc), 0)
        case Nil                => Math.max(max, acc)
      }
      go(s.toList, 0, 0)
    }

    println(solve(binary(n)))

  }

}
