package io.ssledz.hackerrank.fp

/** Update List
  * https://www.hackerrank.com/challenges/fp-update-list/problem
  */
object ex11 extends App {

  def f(arr: List[Int]): List[Int] = arr.map(Math.abs)

  assert(f(List(2, -4, 3, -1, 23, -4, -54)) == List(2, 4, 3, 1, 23, 4, 54))

}
