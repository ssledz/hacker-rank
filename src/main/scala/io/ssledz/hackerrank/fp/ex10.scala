package io.ssledz.hackerrank.fp

/** List Length
  * https://www.hackerrank.com/challenges/fp-list-length/problem
  */
object ex10 extends App {

  def f(arr: List[Int]): Int = arr.zipWithIndex.last._2 + 1

  assert(f(List(2, 5, 1, 4, 3, 7, 8, 6, 0, 9)) == 10)

}
