package io.ssledz.hackerrank.fp

/** Hello World N Times
  * https://www.hackerrank.com/challenges/fp-hello-world-n-times/problem
  */
object ex3 extends App {

  def f(n: Int) = (1 to n).foreach(_ => println("Hello World"))

  f(4)

}
