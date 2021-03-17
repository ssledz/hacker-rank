package io.ssledz.hackerrank.fp

/** The Sums of Powers
  * https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers/problem
  */
object ex40 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    val x = lines.next().toInt
    val n = lines.next().toInt

    val max = (1 to Math.sqrt(x).toInt).takeWhile(y => Math.pow(y, n) <= x).last

    def sum(xs: Set[Int], n: Int): Int = xs.map(x => Math.pow(x, n)).sum.toInt

    def subsets(m: Int): Set[Set[Int]] =
      if (m == 0) Set(Set.empty)
      else
        subsets(m - 1).flatMap { s =>
          val ss = s + m
          if (sum(ss, n) > x) Set(s) else Set(s, ss)
        }

    val sol = subsets(max).filter(s => sum(s, n) == x)

    println(sol.size)

  }
}
