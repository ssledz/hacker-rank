package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 6: Let's Review
  * https://www.hackerrank.com/challenges/30-review-loop/problem
  */
object day06 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val t     = lines.next().toInt

    def join(p: (String, String)): String = p match {
      case (a, b) => s"$a $b"
    }

    def solve(s: String): (String, String) = s.zipWithIndex.foldLeft(("", "")) { case ((l, r), (c, i)) =>
      if (i % 2 == 0) (l + c, r) else (l, r + c)
    }

    (1 to t).foreach { _ =>
      println(join(solve(lines.next())))
    }

  }

}
