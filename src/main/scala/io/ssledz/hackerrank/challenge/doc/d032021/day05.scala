package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 5: Loops
  * https://www.hackerrank.com/challenges/30-loops/problem
  */
object day05 {

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt
    (1 to 10).foreach { i =>
      println(s"$n x $i = ${i * n}")
    }
  }

}
