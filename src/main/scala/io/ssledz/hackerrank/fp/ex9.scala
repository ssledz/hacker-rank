package io.ssledz.hackerrank.fp

/** Sum of Odd Elements
  * https://www.hackerrank.com/challenges/fp-sum-of-odd-elements/problem
  */
object ex9 extends App {

  def f(arr: List[Int]): Int = arr.filter(e => (e + 100) % 2 == 1).sum

  assert(f(List(3, 2, 4, 6, 5, 7, 8, 0, 1)) == 16)

}
