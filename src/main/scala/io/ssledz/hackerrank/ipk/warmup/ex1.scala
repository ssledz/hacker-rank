package io.ssledz.hackerrank.ipk.warmup

/** Sales by Match
  * https://www.hackerrank.com/challenges/sock-merchant/problem
  */
object ex1 {

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt
    val ar    = lines.next().split(' ').map(_.toInt).toList

    val (acc, _, _) = (ar ::: List(101)).sorted.foldLeft((0, 0, 0)) {
      case ((acc, socs, lc), c) if lc == c => (acc, socs + 1, lc)
      case ((acc, socs, _), c)             => (acc + socs / 2, 1, c)
    }

    println(acc)

  }

}
