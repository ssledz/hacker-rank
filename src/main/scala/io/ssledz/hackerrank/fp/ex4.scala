package io.ssledz.hackerrank.fp

/** List Replication
  * https://www.hackerrank.com/challenges/fp-list-replication/problem
  */
object ex4 extends App {

  def f(num: Int, arr: List[Int]): List[Int] = arr.flatMap(n => List.fill(num)(n))

  assert(f(3, List(1, 2, 3, 4)) == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4))

}
