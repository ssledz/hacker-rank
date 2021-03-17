package io.ssledz.hackerrank.fp

/** Sequence full of colors
  * https://www.hackerrank.com/challenges/sequence-full-of-colors/problem
  */
object ex41 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    val n = lines.next().toInt

    def fullOfColors(s: String): Boolean = {

      val len = s.length

      def go(i: Int, rg: Int, yb: Int): Boolean = {
        if (i == len) rg == 0 && yb == 0
        else {
          val c = s.charAt(i)
          if (c == 'R') rg + 1 <= 1 && go(i + 1, rg + 1, yb)
          else if (c == 'G') rg - 1 >= -1 && go(i + 1, rg - 1, yb)
          else if (c == 'Y') yb + 1 <= 1 && go(i + 1, rg, yb + 1)
          else yb - 1 >= -1 && go(i + 1, rg, yb - 1)
        }
      }
      go(0, 0, 0)
    }

    (1 to n).foreach { _ =>
      println(if (fullOfColors(lines.next())) "True" else "False")
    }
    
  }
}
