package io.ssledz.hackerrank.fp

/** Computing the GCD
  * https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd/problem
  */
object ex27 {

  def main(args: Array[String]): Unit = {

    val a :: b :: Nil = io.Source.stdin.getLines().next().split(' ').map(_.toInt).toList

    def gcd(a: Int, b: Int): Int =
      if (a < b) gcd(b, a)
      else if (b == 0) a
      else gcd(b, a % b)

    println(gcd(a, b))

  }

}
