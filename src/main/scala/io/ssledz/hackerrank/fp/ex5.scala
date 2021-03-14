package io.ssledz.hackerrank.fp

/** Filter Array
  * https://www.hackerrank.com/challenges/fp-filter-array/problem
  */
object ex5 extends App {

  def f(delim: Int, arr: List[Int]): List[Int] = arr.filter(_ < delim)

  assert(f(3, List(10, 9, 8, 2, 7, 5, 1, 3, 0)) == List(2, 1, 0))
}
