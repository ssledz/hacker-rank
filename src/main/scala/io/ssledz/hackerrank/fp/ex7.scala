package io.ssledz.hackerrank.fp

/** Array Of N Elements
  * https://www.hackerrank.com/challenges/fp-array-of-n-elements/problem
  */
object ex7 extends App {

  def f(num: Int): List[Int] = {
    val list: List[Int] = (0 until num).toList
    list
  }

  assert(f(10) == List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))

}
