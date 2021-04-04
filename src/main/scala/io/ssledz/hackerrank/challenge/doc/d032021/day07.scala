package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 7: Arrays
  * https://www.hackerrank.com/challenges/30-arrays/problem
  */
object day07 {

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt
    println(lines.next().split(' ').map(_.toInt).reverse.map(_.toString).mkString(" "))
  }

}
