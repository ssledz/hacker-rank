package io.ssledz.hackerrank.fp

/** String Compression
  * https://www.hackerrank.com/challenges/string-compression/problem
  */
object ex35 {

  def main(args: Array[String]): Unit = {

    val msg = io.Source.stdin.getLines().next()

    def compress(msg: String): String =
      (msg + "|").tail
        .foldLeft((msg.head, 1, new StringBuilder)) {
          case ((last, cnt, acc), c) if last == c => (c, cnt + 1, acc)
          case ((last, cnt, acc), c) if last != c =>
            (c, 1, if (cnt == 1) acc.append(last) else acc.append(s"$last$cnt"))
        }
        ._3
        .toString

    println(compress(msg))

  }

}
