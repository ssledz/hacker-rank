package io.ssledz.hackerrank.fp

/** Evaluating e^x
  *
  * https://www.hackerrank.com/challenges/eval-ex/problem
  */
object ex12 extends App {

  def fact(n: Int): Long = {
    def go(n: Int, acc: Long): Long = if (n <= 1) acc else go(n - 1, n * acc)
    go(n, 1)
  }

  def e(x: Double): Double = {
    def exp(n: Int, acc: Double): Double = {
      if (n <= 0) acc else exp(n - 1, acc + Math.pow(x, n) / fact(n))
    }
    exp(9, 1)
  }

  assert(e(20) ~= 2423600.1887)
  assert(e(5) ~= 143.6895)
  assert(e(0.5000) ~= 1.6487)
  assert(e(-0.5000) ~= 0.6065)

}
