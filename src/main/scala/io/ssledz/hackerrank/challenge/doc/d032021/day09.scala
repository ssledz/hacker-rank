package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 9: Recursion 3
  * https://www.hackerrank.com/challenges/30-recursion/problem
  */
object day09 {

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val n     = lines.next().trim.toInt

    def factorial(n: Int): Int = {
      def go(n: Int, acc: Int): Int =
        if (n <= 1) acc
        else go(n - 1, n * acc)
      go(n, 1)
    }

    println(factorial(n))

  }

}
