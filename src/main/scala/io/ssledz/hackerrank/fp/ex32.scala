package io.ssledz.hackerrank.fp

/** String-o-Permute
  * https://www.hackerrank.com/challenges/string-o-permute/problem
  */
object ex32 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val t     = lines.next().toInt

    def swap(s: String): String = {
      def go(xs: List[Char], acc: StringBuilder): StringBuilder = xs match {
        case a :: b :: rest => go(rest, acc.append(b).append(a))
        case Nil            => acc
      }
      go(s.toList, new StringBuilder).toString
    }

    (1 to t).foreach(_ => println(swap(lines.next())))

  }

}
