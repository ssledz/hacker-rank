package io.ssledz.hackerrank.fp

/** String Mingling
  * https://www.hackerrank.com/challenges/string-mingling/problem
  */
object ex31 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val p = lines.next()
    val q = lines.next()

    println(p.zip(q).map { case (p, q) => p.toString + q.toString }.mkString)

  }

}
