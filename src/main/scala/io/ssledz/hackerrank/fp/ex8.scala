package io.ssledz.hackerrank.fp

/** Reverse a List
  * https://www.hackerrank.com/challenges/fp-reverse-a-list/problem
  */
object ex8 extends App {

  def f(arr: List[Int]): List[Int] = arr.foldLeft(List.empty[Int])((acc, x) => x :: acc)

  assert(f(List(19, 22, 3, 28, 26, 17, 18, 4, 28, 0)) == List(0, 28, 4, 18, 17, 26, 28, 3, 22, 19))

}
