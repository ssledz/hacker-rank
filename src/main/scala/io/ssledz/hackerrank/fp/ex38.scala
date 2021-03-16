package io.ssledz.hackerrank.fp

/** String Reductions
  * https://www.hackerrank.com/challenges/string-reductions/problem
  */
object ex38 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    def rm(s: String): String =
      s.foldLeft(Set.empty[Char], new StringBuilder) {
        case ((s, acc), c) if s contains c => (s, acc)
        case ((s, acc), c)                 => (s + c, acc.append(c))
      }._2
        .toString

    println(rm(lines.next()))

  }

}
