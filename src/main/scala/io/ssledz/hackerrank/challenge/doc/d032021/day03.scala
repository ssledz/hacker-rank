package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 3: Intro to Conditional Statements
  * https://www.hackerrank.com/challenges/30-conditional-statements/problem
  */
object day03 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    val n = lines.next().toInt

    val msg = if (n % 2 == 1 || (6 to 20).contains(n)) "Weird" else "Not Weird"

    println(msg)

  }

}
