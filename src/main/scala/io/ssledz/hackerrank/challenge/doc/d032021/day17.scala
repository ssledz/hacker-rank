package io.ssledz.hackerrank.challenge.doc.d032021

import scala.util.{Failure, Success, Try}

/** Day 17: More Exceptions
  * https://www.hackerrank.com/challenges/30-more-exceptions/problem
  */
object day17 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt

    (1 to n).foreach { _ =>
      val arr = lines.next().split(' ').map(_.toInt)
      val c   = new Calculator
      Try(c.power(arr(0), arr(1))) match {
        case Failure(exception) => println(exception.getMessage)
        case Success(value)     => println(value)
      }
    }
  }

  class Calculator {
    def power(n: Int, p: Int): Long =
      if (n < 0 || p < 0) throw new Exception("n and p should be non-negative")
      else Math.pow(n, p).toLong
  }

}
