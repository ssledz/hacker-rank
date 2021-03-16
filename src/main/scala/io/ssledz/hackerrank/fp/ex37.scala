package io.ssledz.hackerrank.fp

/** Prefix Compression
  * https://www.hackerrank.com/challenges/prefix-compression/problem
  */
object ex37 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    def prefix(x: String, y: String): String =
      x.zip(y).takeWhile { case (a, b) => a == b }.map(_._1).mkString

    val x = lines.next()
    val y = lines.next()

    val p                       = prefix(x, y)
    def show(a: String): String = s"${a.size} $a"

    println(show(p))
    println(show(x.stripPrefix(p)))
    println(show(y.stripPrefix(p)))

  }
}
