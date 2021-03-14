package io.ssledz.hackerrank.fp

/** Fibonacci Numbers
  * https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers/problem
  */
object ex28 {

  def main(args: Array[String]): Unit = {

    val n = io.Source.stdin.getLines().next().toInt

    import collection.mutable

    def memo[A, B](cache: mutable.Map[A, B])(f: A => B): A => B = a => {
      cache.get(a) match {
        case Some(b) => b
        case None =>
          val b = f(a)
          cache.update(a, b)
          b
      }
    }

    val cache = mutable.Map.empty[Int, Long]

    def fib(n: Int): Long = {
      val fibM = memo(cache)(fib)
      if (n == 1) 0
      else if (n == 2) 1
      else fibM(n - 1) + fibM(n - 2)
    }

    println(fib(n))

  }
}
