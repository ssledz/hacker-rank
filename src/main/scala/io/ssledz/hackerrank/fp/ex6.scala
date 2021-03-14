package io.ssledz.hackerrank.fp

/** Filter Positions in a List
  * https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list/problem
  */
object ex6 extends App {

  def f(arr: List[Int]): List[Int] = arr.zipWithIndex.filter { case (_, i) => (i + 1) % 2 == 0 }.map(_._1)

  assert(f(List(2, 5, 3, 4, 6, 7, 9, 8)) == List(5, 4, 7, 8))

}
