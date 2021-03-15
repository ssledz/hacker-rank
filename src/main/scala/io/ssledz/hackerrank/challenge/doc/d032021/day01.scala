package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 1: Data Types
  * https://www.hackerrank.com/challenges/30-data-types/problem
  */
object day01 extends App {
  val i = 4
  val d = 4.0
  val s = "HackerRank "

  val lines = io.Source.stdin.getLines()

  println(i + lines.next().toInt)
  println(d + lines.next().toDouble)
  println(s + lines.next())

}
